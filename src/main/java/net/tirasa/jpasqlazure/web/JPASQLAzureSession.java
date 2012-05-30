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
package net.tirasa.jpasqlazure.web;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class JPASQLAzureSession extends AuthenticatedWebSession {

    public JPASQLAzureSession(Request request) {
        super(request);
    }

    @Override
    public boolean authenticate(String userName, String password) {
        super.signIn(userName.equals("jpasqlazure") && password.equals("95218316"));

        return isSignedIn();
    }

    @Override
    public Roles getRoles() {
        return isSignedIn() ? new Roles(Roles.USER) : null;
    }
}
