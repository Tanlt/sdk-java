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
package org.openstack4j.openstack.compute.domain.actions;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * 
 * Create Snapshot action which creates a new Image snapshot from the present state of the server instance
 * 
 * @author Jeremy Unruh
 */
@JsonRootName("createImage")
public class CreateSnapshotAction implements ServerAction {

    private static final long serialVersionUID = 1L;

    @JsonProperty
    private String name;
    
    @JsonProperty
    private Map<String, String> metadata;
    
    public CreateSnapshotAction() { }
    
    public CreateSnapshotAction(String name) {
        this.name = name;
    }
    
    public static CreateSnapshotAction create(String name) {
        return new CreateSnapshotAction(name);
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }
    
    
    
}
