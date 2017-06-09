/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anyframe.query.impl;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.anyframe.query.QueryService;
import org.anyframe.query.vo.LobVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * TestCase Name : QueryServiceSybaseBlobClobTest <br>
 * <br>
 * [Description] : In the case where DMBS type is Sybase, 
 * CLOB and BLOB Handling methods are tested and verified. <br>
 * [Main Flow]
 * <ul>
 * <li>#-1 Positive Case : After entering BLOB, CLOB type data, relevant data 
 * is searched and its result is verified. </li>
 * <li>#-2 Positive Case : After entering BLOB, CLOB type data, relevant data 
 * is included in specific Result Class. </li>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/lobhandler/sybase/context-*.xml" })
public class QueryServiceSybaseBlobClobTest {
	@Inject
	@Named("queryService")
	private QueryService queryService = null;
	@Inject
	@Named("dataSource")
	private DataSource dataSource = null;

	/**
	 * Table TB_BINARY_TEST is created for test. 
	 */
	@Before
	public void onSetUp() throws Exception {
		/*
		System.out.println("Attempting to drop old table");
		try {
			queryService.updateBySQL("DROP TABLE TB_BINARY_TEST",
					new String[] {}, new Object[] {});
		} catch (Exception e) {
			System.out.println("Fail to DROP Table.");
		}

		String sybaseCreate = "CREATE TABLE TB_BINARY_TEST ( bin_id numeric(5) PRIMARY KEY, myblob varbinary(20000), myclob text)";
		queryService
				.updateBySQL(sybaseCreate, new String[] {}, new Object[] {});
				*/

	}

	/**
	 * [Flow #-1] Positive Case : After entering BLOB, CLOB type data, 
	 * relevant data is searched and its result is verified. 
	 * 
	 * @throws Exception
	 *             throws exception which is from QueryService
	 */
	@Test
	public void testFindClobBlob() throws Exception {
		/*
		// 1. set data for insert
		insertClobBlob();

		// 2. execute query
		Collection results = queryService.find("findBlobClob",
				new Object[] { "5" });
		assertEquals(1, results.size());

		// 3. assert
		Iterator resultItr = results.iterator();
		while (resultItr.hasNext()) {
			Map binary = (Map) resultItr.next();
			assertEquals("Fail to find clob.", val, binary.get("myclob"));
			assertEquals("Fail to find blob.", "12345", new String(
					(byte[]) binary.get("myblob")));
		}*/
	}

	/**
	 * [Flow #-2] Positive Case : After entering BLOB, CLOB type data, 
	 * relevant data is included in specific Result Class. 
	 * 
	 * @throws Exception
	 *             throws exception which is from QueryService
	 */
	@Test
	public void testFindClobBlobWithResultClass() throws Exception {
		/*
		// 1. set data for insert
		insertClobBlob();

		// 2. execute query
		Collection results = queryService.find("findBlobClobWithResultClass",
				new Object[] { "5" });
		assertEquals(1, results.size());

		// 3. assert
		Iterator resultItr = results.iterator();
		while (resultItr.hasNext()) {
			LobVO binary = (LobVO) resultItr.next();
			assertEquals("Fail to find clob.", val, binary.getMyclob());
			assertEquals("Fail to find blob.", "12345", new String(binary
					.getMyblob()));
		}*/
	}

	/**
	 * By calling for create() method of QueryService for test, BLOB, CLOB type data is entered. 
	 * 
	 * @throws Exception
	 *             throws exception which is from QueryService
	 */
	private void insertClobBlob() throws Exception {
		// 1. execute query
		queryService.create("insertBlobClob", new Object[] { new Integer(5),
				"12345".getBytes(), val });
		queryService.create("insertBlobClob", new Object[] { new Integer(6),
				"12345".getBytes(), val });
	}

	// test data
	private String val = "1The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "2The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "3The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "4The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "5The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "6The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "7The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "8The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "9The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "10The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "11The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "12The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "13The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "14The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "15The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "16The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "17The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "18The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "19The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "20The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "21The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "22The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "23The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "24The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "25The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "26The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "27The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "28The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "29The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n"
			+ "30The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom. The rose of Sharon is in blossom.\n";
}
