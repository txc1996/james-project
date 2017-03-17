/*
TODO

Q1 Add APACHE license
 */


package org.apache.james.transport.matchers;

import org.apache.james.mailbox.MailboxManager;
import org.apache.james.mailbox.MailboxSession;
import org.apache.james.mailbox.exception.MailboxException;
import org.apache.james.mailbox.model.MailboxPath;
import org.apache.james.mailbox.model.QuotaRoot;
import org.apache.james.mailbox.quota.QuotaManager;
import org.apache.james.mailbox.quota.QuotaRootResolver;
import org.apache.mailet.Mail;
import org.apache.mailet.MailAddress;
import org.apache.mailet.base.GenericMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IsOverQuota extends GenericMatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(IsOverQuota.class);

    private QuotaRootResolver quotaRootResolver;
    private QuotaManager quotaManager;
    private MailboxManager mailboxManager;

    /*
    TODO

    Q2 Make these fields final
     */

    @Inject
    public void setQuotaRootResolver(QuotaRootResolver quotaRootResolver) {
        this.quotaRootResolver = quotaRootResolver;
    }

    @Inject
    public void setQuotaManager(QuotaManager quotaManager) {
        this.quotaManager = quotaManager;
    }

    @Inject
    public void setMailboxManager(MailboxManager mailboxManager) {
        this.mailboxManager = mailboxManager;
    }

    @Override
    public Collection<MailAddress> match(Mail mail) throws MessagingException {
        try {
            List<MailAddress> result = new ArrayList<MailAddress>();
            for (MailAddress mailAddress : mail.getRecipients()) {
                /*
                TODO retrieve the user name that should be used using UsersRepository::getUser
                 */
                MailboxSession mailboxSession = mailboxManager.createSystemSession(mailAddress.getLocalPart(), LOGGER);
                MailboxPath mailboxPath = MailboxPath.inbox(mailboxSession);
                QuotaRoot quotaRoot = quotaRootResolver.getQuotaRoot(mailboxPath);
                /*
                TODO change here to reject emails for account having too many messages or a too big size
                 */
                /*
                TODO we should update the quota with the e-mails value to be more precise on the
                 */
                if (quotaManager.getMessageQuota(quotaRoot).isOverQuota() &&
                    quotaManager.getStorageQuota(quotaRoot).isOverQuota()) {
                    result.add(mailAddress);
                }
            }
            return result;
        } catch(MailboxException e) {
            throw new MessagingException("Exception while checking quotas", e);
        }
    }
}
