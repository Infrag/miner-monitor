/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import static org.obozek.minermonitor.view.Navigation.INDEX;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author infragile
 */
@URLMapping(id = INDEX, viewId = "/view/index.xhtml", pattern = "/")
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class IndexBean {

}
