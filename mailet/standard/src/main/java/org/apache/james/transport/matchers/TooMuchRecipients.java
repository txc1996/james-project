/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.transport.matchers;

import java.util.ArrayList;
import java.util.Collection;

import javax.mail.MessagingException;

import org.apache.mailet.Mail;
import org.apache.mailet.MailAddress;
import org.apache.mailet.base.GenericMatcher;

import com.google.common.collect.ImmutableList;

public class TooMuchRecipients extends GenericMatcher {

    private int maximumRecipientCount;

    @Override
    public void init() throws MessagingException {
    	String condition = getCondition();
    	
    	if(condition == null){
    		throw new MessagingException("it should have a condition");
    	}
    	
    	try {
    		maximumRecipientCount = Integer.parseInt(condition);
		} catch (Exception e) {
			throw new MessagingException("Condition should be a number");
		}
    	
    	if(maximumRecipientCount < 1){
    		throw new MessagingException("it should be positive condition");
    	}
    }

    @Override
    public Collection<MailAddress> match(Mail mail) throws MessagingException {
    	if(mail.getRecipients().size() > maximumRecipientCount){
    		return mail.getRecipients();
    	}
        return ImmutableList.of();
    }
}
