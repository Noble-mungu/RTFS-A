/*
 * Copyright 2015-2021 Micro Focus or one of its affiliates.
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
package clean;

import com.hpe.caf.worker.testing.ContentFileTestExpectation;

/**
 * fraud-detectionTestExpectation forms a component of the test item, and contains the expected fraud-detectionResult, used to compare
 * with the actual worker result.
 */
public class fraud-detectionTestExpectation  extends ContentFileTestExpectation {

    /**
     * fraud-detectionResult read in from the yaml test case, used to validate the result of the worker is as expected.
     */
    private fraud-detectionResult result;

    public fraud-detectionTestExpectation() {
    }

    public fraud-detectionResult getResult() {
        return result;
    }

    public void setResult(fraud-detectionResult result) {
        this.result = result;
    }
}
