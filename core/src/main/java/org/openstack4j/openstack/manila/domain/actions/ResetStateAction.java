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
package org.openstack4j.openstack.manila.domain.actions;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.openstack4j.model.manila.Share;

/**
 * Reset the state of a share.
 *
 * @author Daniel Gonzalez Nothnagel
 */
@JsonRootName("os-reset_status")
public class ResetStateAction implements ShareAction {
    private static final long serialVersionUID = 1L;

    private Share.Status status;

    ResetStateAction(Share.Status status) {
        this.status = status;
    }

    public Share.Status getStatus() {
        return status;
    }
}
