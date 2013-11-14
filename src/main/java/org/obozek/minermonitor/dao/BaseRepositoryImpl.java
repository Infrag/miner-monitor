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
package org.obozek.minermonitor.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.obozek.filterlib.EntityManagerFilteringRepository;
import org.obozek.filterlib.FilteringRepository;
import org.obozek.filterlib.PageFilter;
import org.obozek.filterlib.dao.PreFilterAccessor;
import org.obozek.minermonitor.repository.SpringDataFilteringRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author Ondrej.Bozek
 */
@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable, U extends PageFilter>
        extends SimpleJpaRepository<T, ID> implements FilteringRepository<T, U, Page<T>>
{

    private EntityManager entityManager;
    private EntityManagerFilteringRepository<T, Pageable> filteringRepository;

    // There are two constructors to choose from, either can be used.
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager,
            PreFilterAccessor preFilterAccessor)
    {
        super(domainClass, entityManager);
        // This is the recommended method for accessing inherited class dependencies.
        this.entityManager = entityManager;
        filteringRepository = new SpringDataFilteringRepository<>(
                domainClass, entityManager, preFilterAccessor);
    }

    public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation,
            EntityManager entityManager, PreFilterAccessor preFilterAccessor)
    {
        super(entityInformation, entityManager);
        // This is the recommended method for accessing inherited class dependencies.
        this.entityManager = entityManager;
        filteringRepository = new SpringDataFilteringRepository<>(
                entityInformation.getJavaType(), entityManager, preFilterAccessor);
    }

    @Override
    public Page<T> filter(U filter)
    {
        Page<T> page = filteringRepository.filter(filter);
        return page;
    }
}
