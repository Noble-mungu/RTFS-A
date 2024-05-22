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
package creditcardproducer;

import com.hpe.caf.api.worker.TaskMessage;
import com.hpe.caf.worker.testing.*;
import org.testng.Assert;

/**
 * Processor for validation of the worker result, compares with the expected result in the test item.
 */
public class creditcardproducerResultValidationProcessor extends ContentResultValidationProcessor<creditcardproducerResult, creditcardproducerTestInput, creditcardproducerTestExpectation> {

    public creditcardproducerResultValidationProcessor(WorkerServices workerServices) {
        super(workerServices.getDataStore(), workerServices.getCodec(), creditcardproducerResult.class, creditcardproducerResultAccessors::getTextData, SettingsProvider.defaultProvider.getSetting(SettingNames.expectedFolder));
    }

    /**
     * Validates the result by comparing the test expectation in the test item with the actual worker result.
     * First it asserts that the result has the correct worker status.
     * Then it passes the test item and worker result back to the superclass.
     * The superclass compares the referenced data in the worker result with the test item and calculates a similarity percentage
     * between the text in the worker result with the text in the expected result.
     * @param testItem
     * @param message
     * @param workerResult
     * @return boolean
     * @throws Exception
     */
    @Override
    protected boolean processWorkerResult(TestItem<creditcardproducerTestInput, creditcardproducerTestExpectation> testItem, TaskMessage message, creditcardproducerResult workerResult) throws Exception {
        Assert.assertEquals(testItem.getExpectedOutputData().getResult().workerStatus, workerResult.workerStatus);
        return super.processWorkerResult(testItem, message, workerResult);
    }
}
