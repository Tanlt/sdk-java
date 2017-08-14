/*******************************************************************************
 *  Copyright 2017 Huawei TLD
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
/*******************************************************************************
 *******************************************************************************/
package org.openstack4j.sample.trove;

import java.util.List;

import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.openstack.database.constants.DatastoreType;
import org.openstack4j.openstack.database.domain.DatastoreVersion;
import org.openstack4j.openstack.database.domain.InstanceFlavor;
import org.openstack4j.openstack.trove.constant.VolumeType;
import org.openstack4j.openstack.trove.domain.DatabaseInstance;
import org.openstack4j.openstack.trove.domain.DatabaseReplicaInstanceCreate;
import org.openstack4j.openstack.trove.domain.Datastore;
import org.openstack4j.openstack.trove.domain.Volume;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 数据库实例的操作，都是耗时操作（有的需要好几十分钟），
 * 而且这些操作都要求实例处于某个状态中，所以测试用例要自己手动一个个去跑。
 *
 * @author QianBiao.NG
 * @date   2017-08-08 13:52:22
 */
@Test(suiteName = "Database/Instance/Sample2")
public class DatabaseInstanceSample2 extends BaseTroveSample {

	// ====================================================================//
	// 数据库实例的操作，都是耗时操作（有的需要好几十分钟）， //
	// 而且这些操作都要求实例处于某个状态中，所以测试用例要自己手动一个个去跑。 //
	// ====================================================================//

	@Test
	public void testCreateReplica() {
		// 需要改成实际的 instance id
		String masterInstanceId = "4313ce3e-e928-4701-89f7-be68d72080df";

		DatabaseInstance instance = osclient.trove().instances().get(masterInstanceId);

		Datastore datastore = Datastore.builder().type(org.openstack4j.openstack.trove.constant.DatastoreType.MySQL)
				.version("MySQL-5.6.33").build();
		
		Volume volume = Volume.builder().type(VolumeType.COMMON).size(100).build();

		DatabaseReplicaInstanceCreate replicaCreate = DatabaseReplicaInstanceCreate.builder().name("sdk-replica").datastore(datastore)
				.flavorRef(instance.getFlavor().getId()).volume(volume).replicaOf(masterInstanceId).replicaCount(1).build();
		DatabaseInstance replica = osclient.trove().instances().createReplica(replicaCreate);
		
		Assert.assertEquals(replica.getName(), "sdk-replica");
		Assert.assertEquals(replica.getStatus(), "BUILD");
		Assert.assertEquals(replica.getDatastore().getType(), org.openstack4j.openstack.trove.constant.DatastoreType.MySQL);
		Assert.assertEquals(replica.getDatastore().getVersion(), "MySQL-5.6.33");
		Assert.assertEquals(replica.getFlavor().getId(), instance.getFlavor().getId());
		Assert.assertEquals(replica.getVolume().getSize().intValue(), 100);
	}

	@Test
	public void testResizeVolume() {
		// 需要改成实际的 instance id
		String instanceId = "60523749-abc4-4957-9447-957dc36634a7";
		ActionResponse response = osclient.trove().instances().resize(instanceId, 120);
		Assert.assertTrue(response.isSuccess());
	}

	@Test
	public void testResizeFlavor() {
		// 需要改成实际的 instance id
		String instanceId = "60f9fcbb-30a4-4eea-8e5b-1de0963ea970";

		DatastoreVersion datastoreVersion = this.getFirstDatastoreVersion(DatastoreType.MySQL);
		List<InstanceFlavor> flavors = osclient.database().flavors().list(datastoreVersion.getId(), "eu-de");

		InstanceFlavor newFlavor = null;
		DatabaseInstance databaseInstance = osclient.trove().instances().get(instanceId);
		String flavorId = databaseInstance.getFlavor().getId();
		for (InstanceFlavor flavor : flavors) {
			if (!flavor.getId().equals(flavorId)) {
				newFlavor = flavor;
			}
		}

		ActionResponse response = osclient.trove().instances().resize(instanceId, newFlavor.getId());
		Assert.assertTrue(response.isSuccess());
	}

	@Test
	public void testRestartInstance() {
		// 需要改成实际的 instance id
		String instanceId = "4313ce3e-e928-4701-89f7-be68d72080df";
		ActionResponse response = osclient.trove().instances().restart(instanceId);
		Assert.assertTrue(response.isSuccess());
	}

	@Test
	public void testDeleteInstance() {
		// 需要改成实际的 instance id
		String instanceId = "3a0d68e6-8538-420c-8936-f4c832de2bb2";
		ActionResponse response = osclient.trove().instances().delete(instanceId);
		Assert.assertTrue(response.isSuccess());
	}

}
