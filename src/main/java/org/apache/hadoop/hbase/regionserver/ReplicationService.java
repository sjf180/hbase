/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.regionserver;

import java.io.IOException;

import org.apache.hadoop.hbase.Server;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Gateway to Cluster Replication.  
 * Used by {@link org.apache.hadoop.hbase.regionserver.HRegionServer}.
 * One such application is a cross-datacenter
 * replication service that can keep two hbase clusters in sync.
 */
public interface ReplicationService {

  /**
   * Initializes the replication service object.
   * @throws IOException
   */
  public void initialize(Server rs, FileSystem fs, Path logdir,
                         Path oldLogDir) throws IOException;

  /**
   * Start replication services.
   * @throws IOException
   */
  public void startReplicationService() throws IOException;

  /**
   * Stops replication service.
   */
  public void stopReplicationService();
}