/*
 * Project: OLK DMVS :: dmvs-app
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Mar 1, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.obozek.minermonitor.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.obozek.filterlib.PageFilter;
import org.obozek.filterlib.dao.PreFilterAccessor;
import org.obozek.minermonitor.dao.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import static org.springframework.data.querydsl.QueryDslUtils.QUERY_DSL_PRESENT;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 *
 * @author Ondrej.Bozek
 */
@NoRepositoryBean
public class BaseRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable, U extends PageFilter>
        extends JpaRepositoryFactoryBean<R, T, I>
{

    @Autowired
    private PreFilterAccessor preFilterAccessor;

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager)
    {
        return new BaseRepositoryFactory(entityManager, preFilterAccessor);
    }

    private static class BaseRepositoryFactory<T, I extends Serializable, U extends PageFilter>
            extends JpaRepositoryFactory
    {

        private EntityManager entityManager;
        private PreFilterAccessor preFilters;

        public BaseRepositoryFactory(EntityManager entityManager, PreFilterAccessor preFilterAccessor)
        {
            super(entityManager);
            this.entityManager = entityManager;
            this.preFilters = preFilterAccessor;
        }

        @Override
        protected Object getTargetRepository(RepositoryMetadata metadata)
        {
            Class<?> repositoryInterface = metadata.getRepositoryInterface();

            JpaEntityInformation<?, Serializable> entityInformation =
                    getEntityInformation(metadata.getDomainType());
            return new BaseRepositoryImpl<T, I, U>(
                    (Class<T>) metadata.getDomainType(), entityManager, preFilters);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata)
        {
            // The RepositoryMetadata can be safely ignored, it is used by the JpaRepositoryFactory
            //to check for QueryDslJpaRepository's which is out of scope.
            return BaseRepository.class;
        }

        /**
         * Returns whether the given repository interface requires a QueryDsl
         * specific implementation to be chosen.
         *
         * @param repositoryInterface
         * @return
         */
        private boolean isQueryDslExecutor(Class<?> repositoryInterface)
        {
            return QUERY_DSL_PRESENT
                    && QueryDslPredicateExecutor.class
                    .isAssignableFrom(repositoryInterface);
        }
    }
}
