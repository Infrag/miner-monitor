/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author infragile
 * @param <T>
 * @param <F>
 */
public abstract class LazyPaginationModel<T extends RowKeyAccess, F extends Pageable> extends LazyDataModel<T> {

    public static final int DEFAULT_PAGE_SIZE = 20;
    private final Map<String, T> cachedMap = new HashMap<>();

    {
        setPageSize(DEFAULT_PAGE_SIZE);
    }

    @Override
    public T getRowData(String rowKey) {
        return cachedMap.get(rowKey);
    }

    @Override
    public Object getRowKey(T item) {
        return item.getRowKey();
    }

    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        Sort.Direction direction = null;
        if (SortOrder.ASCENDING.equals(sortOrder)) {
            direction = Sort.Direction.ASC;
        }
        if (SortOrder.DESCENDING.equals(sortOrder)) {
            direction = Sort.Direction.DESC;
        }
        Sort sort = null;
        if (sortField != null) {
            Sort.Order order = direction != null ? new Sort.Order(direction, sortField) : new Sort.Order(sortField);
            sort = new Sort(order);
        }
        F pageRequest = createPageRequest(pageSize != 0 ? first / pageSize : first, pageSize, sort, filters);
        Page<T> page = getPage(pageRequest);
        setRowCount(Long.valueOf(page.getTotalElements()).intValue());
        cachedMap.clear();
        List<T> result = new ArrayList<>();
        for (T t : page) {
            result.add(t);
            cachedMap.put(t.getRowKey(), t);
        }
        return result;
    }

    public abstract Page<T> getPage(F pageReguest);

    public abstract F createPageRequest(int page, int size, Sort sort, Map<String, String> filters);
}
