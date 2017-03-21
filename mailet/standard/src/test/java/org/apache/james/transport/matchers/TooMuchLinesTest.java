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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TooMuchLinesTest {

    private TooMuchLines testee;

    @Before
    public void setUp() {
        testee = new TooMuchLines();
    }

    @Test
    public void initShouldThrowOnAbsentCondition() {
        /*
        What happens if there is no condition?

        We should throw an exception
         */
    }

    @Test
    public void initShouldThrowOnInvalidCondition() {
        /*
        What happens when condition is not a number? We should throw.
         */
    }

    @Test
    public void initShouldThrowOnEmptyCondition() {
        /*
        What happens when condition is empty? We should throw.
         */
    }

    @Test
    public void initShouldThrowOnZeroCondition() {
        /*
        What happens when condition is zero? We should throw.
         */
    }

    @Test
    public void initShouldThrowOnNegativeCondition() {
        /*
        What happens when condition is negative? We should throw.
         */
    }

    @Test
    public void matchShouldReturnNoRecipientWhenMailHaveNoMimeMessage() {
        /*
        Start the matcher with condition = 100

        What happens with a mail with no mime message?

        We should return empty list
         */
    }

    @Test
    public void matchShouldAcceptMailsUnderLimit() {
        /*
        Start the matcher with condition = 100

        What happens with a mail with just a few lines?

        We should return empty list
         */
    }

    @Test
    public void matchShouldRejectMailsOverLimit() {
        /*
        Start the matcher with condition = 10

        What happens with a mail with 11 line body?

        We should return the list of Recipients
         */
    }

}
