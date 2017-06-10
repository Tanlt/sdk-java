/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package org.openstack4j.api.networking.ext;

import java.util.List;
import java.util.Map;

import org.openstack4j.common.RestService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.network.ext.FirewallRule;
import org.openstack4j.model.network.ext.FirewallRuleUpdate;

/**
 * <p>Networking (Neutron) FwaaS FirewallRule Rule Extension API</p>
 * 
 * <p>Represents a collection of attributes like ports, ip addresses which define match 
 * 		criteria and action (allow, or deny) that needs to be taken on the matched data traffic.</p>
 * 
 * <p>
	 * The FWaaS extension provides OpenStack users with the ability to deploy firewalls to protect their networks. The FWaaS extension enables you to:
	 * <ul>
	 * 		<li>Apply FirewallRule rules on traffic entering and leaving tenant networks.</li>
	 * 		<li>Support for applying tcp, udp, icmp, or protocol agnostic rules.</li>
	 * 		<li>Creation and sharing of FirewallRule policies which hold an ordered collection of the FirewallRule rules.</li>
	 * 		<li>Audit FirewallRule rules and policies.</li>
	 * </ul>
 * </p>
 * 
 * @author Vishvesh Deshmukh
 */
public interface FirewallRuleService extends RestService {
    /**
     * List all FirewallRules(s) that the current tenant has access to.
     *
     * @return list of all FirewallRules(s)
     */
    List<? extends FirewallRule> list();

    /**
     * Returns list of FirewallRules(s) filtered by parameters.
     * 
     * @param filteringParams map (name, value) of filtering parameters
     * @return filtered list of FirewallRules(s)
     */
    List<? extends FirewallRule> list(Map<String, String> filteringParams);

    /**
     * Get the specified FirewallRule by ID
     *
     * @param firewallRuleId the FirewallRule identifier
     * @return the FirewallRule or null if not found
     */
    FirewallRule get(String firewallRuleId);
    
    /**
     * Delete the specified FirewallRule by ID
     * @param firewallRuleId the FirewallRule identifier
     * @return the action response
     */
    ActionResponse delete(String firewallRuleId);
    
    /**
     * Create a FirewallRule
     * @param firewallRule
     * @return FirewallRule
     */
    FirewallRule create(FirewallRule firewallRule);
    
    /**
     * Update a FirewallRule
     * @param firewallRuleId the FirewallRule identifier
     * @param firewallRuleUpdate firewallRuleUpdate
     * @return FirewallRule
     */
    FirewallRule update(String firewallRuleId, FirewallRuleUpdate firewallRuleUpdate);
}
