/*
 * Project: MinerMonitor
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Nov 12, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.obozek.minermonitor.client.dto;

/**
 *
 * @author Ondrej.Bozek
 */
public enum StatusState {

    W, // - Warning
    I, // - Informational
    S, // - Success
    E, // - Error
    T, // - Timeout (no connection)
    F; // - Fatal (code bug)
}
