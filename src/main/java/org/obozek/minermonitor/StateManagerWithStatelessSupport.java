/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.minermonitor;

import com.sun.faces.application.StateManagerImpl;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author infragile
 */
public class StateManagerWithStatelessSupport extends StateManagerImpl {
    // TODO: do such trick only if view is really stateless

    @Override
    public UIViewRoot restoreView(FacesContext context, String viewId, String renderKitId) {
        UIViewRoot result = super.restoreView(context, viewId, renderKitId);
        if (result == null) {
            return context.getViewRoot();
        } else {
            return result;
        }
    }
}
