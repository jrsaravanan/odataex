/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.fit;

import javax.ws.rs.GET;
import org.apache.olingo.fit.utils.ODataVersion;
import org.apache.olingo.fit.utils.XHTTPMethodInterceptor;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.olingo.fit.utils.ConstantKey;
import org.apache.olingo.fit.utils.Constants;
import org.springframework.stereotype.Service;

@Service
@Path("/V30/Static.svc")
@InInterceptors(classes = XHTTPMethodInterceptor.class)
public class V3Services extends AbstractServices {

  public V3Services() throws Exception {
    super(ODataVersion.v3);
  }

  /**
   * Provide sample large metadata.
   *
   * @return metadata.
   */
  @GET
  @Path("/large/$metadata")
  @Produces("application/xml")
  public Response getLargeMetadata() {
    return getMetadata("large" + StringUtils.capitalize(Constants.get(version, ConstantKey.METADATA)));
  }

  /**
   * Provide sample large metadata.
   *
   * @return metadata.
   */
  @GET
  @Path("/openType/$metadata")
  @Produces("application/xml")
  public Response getOpenTypeMetadata() {
    return getMetadata("openType" + StringUtils.capitalize(Constants.get(version, ConstantKey.METADATA)));
  }

}
