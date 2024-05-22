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

import com.hpe.caf.worker.testing.*;
import com.hpe.caf.worker.testing.execution.AbstractTestControllerProvider;

/**
 * Class providing task factory, validation processor, save result processor, result preparation provider for running integration
 * tests.
 */
public class fraud-detectionTestControllerProvider extends AbstractTestControllerProvider<fraud-detectionConfiguration,
        fraud-detectionTask, fraud-detectionResult, fraud-detectionTestInput, fraud-detectionTestExpectation> {

    public fraud-detectionTestControllerProvider() {
        super(fraud-detectionConstants.WORKER_NAME, fraud-detectionConfiguration::getOutputQueue, fraud-detectionConfiguration.class, fraud-detectionTask.class, fraud-detectionResult.class, fraud-detectionTestInput.class, fraud-detectionTestExpectation.class);
    }

    /**
     * Return a task factory for creating tasks.
     * @param configuration
     * @return fraud-detectionTaskFactory
     * @throws Exception
     */
    @Override
    protected WorkerTaskFactory<fraud-detectionTask, fraud-detectionTestInput, fraud-detectionTestExpectation> getTaskFactory(TestConfiguration<fraud-detectionTask, fraud-detectionResult, fraud-detectionTestInput, fraud-detectionTestExpectation> configuration) throws Exception {
        return new fraud-detectionTaskFactory(configuration);
    }

    /**
     * Return a result validation processor for validating the worker result is the same as the expected result in the test item.
     * @param configuration
     * @param workerServices
     * @return fraud-detectionResultValidationProcessor
     */
    @Override
    protected ResultProcessor getTestResultProcessor(TestConfiguration<fraud-detectionTask, fraud-detectionResult, fraud-detectionTestInput, fraud-detectionTestExpectation> configuration, WorkerServices workerServices) {
        return new fraud-detectionResultValidationProcessor(workerServices);
    }

    /**
     * Return a result preparation provider for preparing test items from YAML files.
     * @param configuration
     * @return fraud-detectionResultPreparationProvider
     */
    @Override
    protected TestItemProvider getDataPreparationItemProvider(TestConfiguration<fraud-detectionTask, fraud-detectionResult, fraud-detectionTestInput, fraud-detectionTestExpectation> configuration) {
        return new fraud-detectionResultPreparationProvider(configuration);
    }

    /**
     * Return a save result processor for generating .testcase and result.content files found in test-data > input folder.
     * @param configuration
     * @param workerServices
     * @return fraud-detectionSaveResultProcessor
     */
    @Override
    protected ResultProcessor getDataPreparationResultProcessor(TestConfiguration<fraud-detectionTask, fraud-detectionResult, fraud-detectionTestInput, fraud-detectionTestExpectation> configuration, WorkerServices workerServices) {
        return new fraud-detectionSaveResultProcessor(configuration, workerServices);
    }

}
