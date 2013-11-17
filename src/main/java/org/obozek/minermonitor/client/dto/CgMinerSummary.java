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

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * config -{"STATUS":[{"STATUS":"S","When":1384261823,"Code":33,"Msg":"CGMiner
 * config","Description":"cgminer 3.7.2"}],"CONFIG":[{"GPU Count":2,"ASC
 * Count":0,"PGA Count":0,"Pool Count":4,"ADL":"Y","ADL in
 * use":"Y","Strategy":"Failover","Log Interval":5,"Device Code":"GPU
 * ","OS":"Linux","Failover-Only":false,"ScanTime":60,"Queue":1,"Expiry":120,"Hotplug":"None"}],"id":1}
 *
 * deviceDetails -
 * {"STATUS":[{"STATUS":"S","When":1384261852,"Code":69,"Msg":"Device
 * Details","Description":"cgminer
 * 3.7.2"}],"DEVDETAILS":[{"DEVDETAILS":0,"Name":"GPU","ID":0,"Driver":"opencl","Kernel":"scrypt","Model":"AMD
 * Radeon HD 7900 Series","Device
 * Path":""},{"DEVDETAILS":1,"Name":"GPU","ID":1,"Driver":"opencl","Kernel":"scrypt","Model":"AMD
 * Radeon HD 7900 Series","Device Path":""}],"id":1}
 *
 * devs - {"STATUS":[{"STATUS":"S","When":1384261865,"Code":9,"Msg":"2 GPU(s) -
 * ","Description":"cgminer
 * 3.7.2"}],"DEVS":[{"GPU":0,"Enabled":"Y","Status":"Alive","Temperature":74.00,"Fan
 * Speed":4274,"Fan Percent":83,"GPU Clock":925,"Memory Clock":1250,"GPU
 * Voltage":1.250,"GPU Activity":64,"Powertune":0,"MHS av":0.49,"MHS
 * 5s":0.49,"Accepted":111,"Rejected":1,"Hardware
 * Errors":0,"Utility":1.45,"Intensity":"18","Last Share Pool":0,"Last Share
 * Time":1384261832,"Total MH":2240.2826,"Diff1 Work":30422,"Difficulty
 * Accepted":28416.00000000,"Difficulty Rejected":256.00000000,"Last Share
 * Difficulty":256.00000000,"Last Valid Work":1384261832,"Device
 * Hardware%":0.0000,"Device Rejected%":0.8415,"Device
 * Elapsed":4584},{"GPU":1,"Enabled":"Y","Status":"Alive","Temperature":74.00,"Fan
 * Speed":2010,"Fan Percent":45,"GPU Clock":925,"Memory Clock":1250,"GPU
 * Voltage":1.125,"GPU Activity":99,"Powertune":0,"MHS av":0.55,"MHS
 * 5s":0.55,"Accepted":141,"Rejected":6,"Hardware
 * Errors":0,"Utility":1.85,"Intensity":"20","Last Share Pool":0,"Last Share
 * Time":1384261862,"Total MH":2517.6310,"Diff1 Work":37587,"Difficulty
 * Accepted":36096.00000000,"Difficulty Rejected":1536.00000000,"Last Share
 * Difficulty":256.00000000,"Last Valid Work":1384261862,"Device
 * Hardware%":0.0000,"Device Rejected%":4.0865,"Device Elapsed":4584}],"id":1}
 *
 * notify -
 * {"STATUS":[{"STATUS":"S","When":1384261879,"Code":60,"Msg":"Notify","Description":"cgminer
 * 3.7.2"}],"NOTIFY":[{"NOTIFY":0,"Name":"GPU","ID":0,"Last
 * Well":1384261879,"Last Not Well":0,"Reason Not Well":"None","*Thread Fail
 * Init":0,"*Thread Zero Hash":0,"*Thread Fail Queue":0,"*Dev Sick Idle
 * 60s":0,"*Dev Dead Idle 600s":0,"*Dev Nostart":0,"*Dev Over Heat":0,"*Dev
 * Thermal Cutoff":0,"*Dev Comms Error":0,"*Dev
 * Throttle":0},{"NOTIFY":1,"Name":"GPU","ID":1,"Last Well":1384261879,"Last Not
 * Well":0,"Reason Not Well":"None","*Thread Fail Init":0,"*Thread Zero
 * Hash":0,"*Thread Fail Queue":0,"*Dev Sick Idle 60s":0,"*Dev Dead Idle
 * 600s":0,"*Dev Nostart":0,"*Dev Over Heat":0,"*Dev Thermal Cutoff":0,"*Dev
 * Comms Error":0,"*Dev Throttle":0}],"id":1}
 *
 * {"STATUS":
 * [{"STATUS":"S","When":1384251030,"Code":11,"Msg":"Summary","Description":"cgminer
 * 3.7.2"}], "SUMMARY":[{"Elapsed":450,"MHS av":1.07,"MHS 5s":1.03,"Found
 * Blocks":0,"Getworks":13,"Accepted":29,"Rejected":0,"Hardware
 * Errors":0,"Utility":3.87,"Discarded":22,"Stale":0,"Get Failures":0,"Local
 * Work":57,"Remote Failures":0,"Network Blocks":3,"Total MH":479.9857,"Work
 * Utility":967.45,"Difficulty Accepted":6848.00000000,"Difficulty
 * Rejected":0.00000000,"Difficulty Stale":0.00000000,"Best Share":5694,"Device
 * Hardware%":0.0000,"Device Rejected%":0.0000,"Pool Rejected%":0.0000,"Pool
 * Stale%":0.0000}], "id":1}
 *
 * @author Ondrej.Bozek
 */
public class CgMinerSummary extends CgMinerResponse {
    
    @SerializedName("SUMMARY")
    private List<SummaryDTO> summary;
    
    public CgMinerSummary(Long id, List<StatusDTO> status, List<SummaryDTO> summary) {
        super(id, status);
        this.summary = summary;
    }
    
    public CgMinerSummary() {
    }
    
    public List<SummaryDTO> getSummary() {
        return summary;
    }
}
