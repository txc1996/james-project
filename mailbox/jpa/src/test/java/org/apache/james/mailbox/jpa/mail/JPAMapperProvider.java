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

package org.apache.james.mailbox.jpa.mail;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang.NotImplementedException;
import org.apache.james.mailbox.MessageUid;
import org.apache.james.mailbox.exception.MailboxException;
import org.apache.james.mailbox.jpa.EntityManagerFactorySupplier;
import org.apache.james.mailbox.jpa.JPAId;
import org.apache.james.mailbox.model.MailboxId;
import org.apache.james.mailbox.model.MessageId;
import org.apache.james.mailbox.store.mail.AnnotationMapper;
import org.apache.james.mailbox.store.mail.AttachmentMapper;
import org.apache.james.mailbox.store.mail.MailboxMapper;
import org.apache.james.mailbox.store.mail.MessageIdMapper;
import org.apache.james.mailbox.store.mail.MessageMapper;
import org.apache.james.mailbox.store.mail.model.DefaultMessageId;
import org.apache.james.mailbox.store.mail.model.Mailbox;
import org.apache.james.mailbox.store.mail.model.MapperProvider;

import com.google.common.collect.ImmutableList;

public class JPAMapperProvider implements MapperProvider {

    @Override
    public MailboxMapper createMailboxMapper() throws MailboxException {
        return new TransactionalMailboxMapper(new JPAMailboxMapper(createEntityManagerFactory()));
    }

    @Override
    public MessageMapper createMessageMapper() throws MailboxException {
        throw new NotImplementedException();
    }

    @Override
    public AttachmentMapper createAttachmentMapper() throws MailboxException {
        throw new NotImplementedException();
    }

    @Override
    public AnnotationMapper createAnnotationMapper() throws MailboxException {
        return new TransactionalAnnotationMapper(new JPAAnnotationMapper(createEntityManagerFactory()));
    }

    @Override
    public MailboxId generateId() {
        return JPAId.of(Math.abs(new Random().nextInt()));
    }

    @Override
    public MessageId generateMessageId() {
        return new DefaultMessageId.Factory().generate();
    }

    @Override
    public void clearMapper() throws MailboxException {
        new EntityManagerFactorySupplier().clear();
    }

    @Override
    public void ensureMapperPrepared() throws MailboxException {

    }

    @Override
    public boolean supportPartialAttachmentFetch() {
        return false;
    }

    private EntityManagerFactory createEntityManagerFactory() {
         return new EntityManagerFactorySupplier().get();
    }

    @Override
    public List<Capabilities> getNotImplemented() {
        return ImmutableList.of(Capabilities.MESSAGE, Capabilities.ATTACHMENT, Capabilities.MOVE, Capabilities.UNIQUE_MESSAGE_ID);
    }

    @Override
    public MessageIdMapper createMessageIdMapper() throws MailboxException {
        throw new NotImplementedException();
    }

    @Override
    public MessageUid generateMessageUid() {
        throw new NotImplementedException();
    }

    @Override
    public long generateModSeq(Mailbox mailbox) throws MailboxException {
        throw new NotImplementedException();
    }

    @Override
    public long highestModSeq(Mailbox mailbox) throws MailboxException {
        throw new NotImplementedException();
    }
}
