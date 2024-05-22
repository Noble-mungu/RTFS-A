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

import com.hpe.caf.worker.testing.*;
import com.hpe.caf.worker.testing.execution.AbstractTestControllerProvider;

/**
 * Class providing task factory, validation processor, save result processor, result preparation provider for running integration
 * tests.
 */
public class creditcardproducerTestControllerProvider extends AbstractTestControllerProvider<creditcardproducerConfiguration,
        creditcardproducerTask, creditcardproducerResult, creditcardproducerTestInput, creditcardproducerTestExpectation> {

    public creditcardproducerTestControllerProvider() {
        super(creditcardproducerConstants.WORKER_NAME, creditcardproducerConfiguration::getOutputQueue, creditcardproducerConfiguration.class, creditcardproducerTask.class, creditcardproducerResult.class, creditcardproducerTestInput.class, creditcardproducerTestExpectation.class);
    }

    /**
     * Return a task factory for creating tasks.
     * @param configuration
     * @return creditcardproducerTaskFactory
     * @throws Exception
     */
    @Override
    protected WorkerTaskFactory<creditcardproducerTask, creditcardproducerTestInput, creditcardproducerTestExpectation> getTaskFactory(TestConfiguration<creditcardproducerTask, creditcardproducerResult, creditcardproducerTestInput, creditcardproducerTestExpectation> configuration) throws Exception {
        return new creditcardproducerTaskFactory(configuration);
    }

    /**
     * Return a result validation processor for validating the worker result is the same as the expected result in the test item.
     * @param configuration
     * @param workerServices
     * @return creditcardproducerResultValidationProcessor
     */
    @Override
    protected ResultProcessor getTestResultProcessor(TestConfiguration<creditcardproducerTask, creditcardproducerResult, creditcardproducerTestInput, creditcardproducerTestExpectation> configuration, WorkerServices workerServices) {
        return new creditcardproducerResultValidationProcessor(workerServices);
    }

    /**
     * Return a result preparation provider for preparing test items from YAML files.
     * @param configuration
     * @return creditcardproducerResultPreparationProvider
     */
    @Override
    protected TestItemProvider getDataPreparationItemProvider(TestConfiguration<creditcardproducerTask, creditcardproducerResult, creditcardproducerTestInput, creditcardproducerTestExpectation> configuration) {
        return new creditcardproducerResultPreparationProvider(configuration);
    }

    /**
     * Return a save result processor for generating .testcase and result.content files found in test-data > input folder.
     * @param configuration
     * @param workerServices
     * @return creditcardproducerSaveResultProcessor
     */
    @Override
    protected ResultProcessor getDataPreparationResultProcessor(TestConfiguration<creditcardproducerTask, creditcardproducerResult, creditcardproducerTestInput, creditcardproducerTestExpectation> configuration, WorkerServices workerServices) {
        return new creditcardproducerSaveResultProcessor(configuration, workerServices);
    }

}
