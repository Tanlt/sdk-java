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
package org.openstack4j.model.storage.block.options;

import org.openstack4j.model.image.ContainerFormat;
import org.openstack4j.model.image.DiskFormat;

/**
 * Options to Upload volume to image service as image
 * 
 * @author Jeremy Unruh
 */
public class UploadImageData {

    private String imageName;
    private ContainerFormat containerFormat = ContainerFormat.BARE;
    private DiskFormat diskFormat = DiskFormat.RAW;
    private boolean force;
    
    private UploadImageData(String imageName) {
        this.imageName = imageName;
    }
    
    /**
     * Creates new UploadImageOptions with the specified image name
     * @param imageName the image name for upload
     * @return UploadImageOptions
     */
    public static UploadImageData create(String imageName) {
        return new UploadImageData(imageName);
    }
    
    /**
     * The container format for this volume image (default is BARE)
     * @param containerFormat the container format
     * @return UploadImageOptions
     */
    public UploadImageData containerFormat(ContainerFormat containerFormat) {
        this.containerFormat = containerFormat;
        return this;
    }
    
    /**
     * The disk format for this volume image (default is RAW)
     * @param diskFormat the disk format
     * @return UploadImageOptions
     */
    public UploadImageData diskFormat(DiskFormat diskFormat) {
        this.diskFormat = diskFormat;
        return this;
    }
    
    public UploadImageData force(boolean isForce) {
        this.force = isForce;
        return this;
    }
    
    /**
     * The image name used as a display name for the upload
     * @param imageName the image name
     * @return UploadImageOptions
     */
    public UploadImageData imageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    public String getImageName() {
        return imageName;
    }

    public ContainerFormat getContainerFormat() {
        return containerFormat;
    }

    public DiskFormat getDiskFormat() {
        return diskFormat;
    }

    public boolean isForce() {
        return force;
    }
    
    
    
}
