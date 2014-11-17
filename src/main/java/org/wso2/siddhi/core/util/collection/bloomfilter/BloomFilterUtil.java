/*
 * Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.siddhi.core.util.collection.bloomfilter;

public class BloomFilterUtil {

	private BloomFilterUtil() {
	}

	/**
	 * Calculates the optimal size of the bloom filter in bits, given
	 * noOfElements and falsePositiveRate
	 * 
	 * @param noOfElements
	 *            Expected number of elements inserted in the bloom filter
	 * @param falsePositiveRate
	 *            Tolerable false positive rate
	 * @return Optimal Size of the bloom filter in bits
	 */
	public static int optimalBloomFilterSize(long noOfElements, double falsePositiveRate) {
		return (int) Math.ceil(-1 * (noOfElements * Math.log(falsePositiveRate)) /
		                       Math.pow(Math.log(2), 2));
	}

	/**
	 * Calculate the optimal number of hash functions for the bloom filter using
	 * bloom filter size and no of elements inserted
	 * 
	 * @param bloomFilterSize
	 *            Bloom Filter vector size
	 * @param noOfElements
	 *            Expected number of elements inserted to the filter
	 * @return Optimal number of hash functions
	 */

	public static int optimalNoOfHash(int bloomFilterSize, long noOfElements) {
		return (int) Math.round(bloomFilterSize / noOfElements * Math.log(2));
	}

}
