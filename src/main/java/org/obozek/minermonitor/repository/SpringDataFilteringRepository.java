/*
 * Project: OLK DMVS :: dmvs-app
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Mar 4, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.obozek.minermonitor.repository;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import org.obozek.filterlib.EntityManagerFilteringRepository;
import org.obozek.filterlib.dao.PreFilterAccessor;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ondrej.Bozek
 */
public class SpringDataFilteringRepository<T, U extends Pageable> extends EntityManagerFilteringRepository<T, U>
{

    private Class<T> domainClass;

    static {
        Set<String> ignoredFields = new HashSet<>();
        ignoredFields.add("count");
        ignoredFields.add("start");
        setIgnoredFields(ignoredFields);

    }

    public SpringDataFilteringRepository(Class<T> domainClass,
            EntityManager entityManager, PreFilterAccessor preFilterAccessor)
    {
        super(entityManager);
        this.domainClass = domainClass;
        setPreFilterAccessor(preFilterAccessor);

    }

    @Override
    protected Class<T> returnedClass()
    {
        return domainClass;
    }
}
