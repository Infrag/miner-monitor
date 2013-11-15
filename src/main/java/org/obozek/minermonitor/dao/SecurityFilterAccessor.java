/*
 * Project: MinerMonitor
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Nov 15, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.obozek.minermonitor.dao;

import java.util.ArrayList;
import java.util.List;
import org.obozek.filterlib.dao.PreFilterAccessor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ondrej.Bozek
 */
@Service
public class SecurityFilterAccessor implements PreFilterAccessor
{

    private static final List<Object> list = new ArrayList<>();

    @Override
    public List<Object> getPreFilters(Class<?> entityClass, Pageable filter)
    {
        return list;
    }
}
