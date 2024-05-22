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
public class dashboardTestControllerProvider extends AbstractTestControllerProvider<dashboardConfiguration,
        dashboardTask, dashboardResult, dashboardTestInput, dashboardTestExpectation> {

    public dashboardTestControllerProvider() {
        super(dashboardConstants.WORKER_NAME, dashboardConfiguration::getOutputQueue, dashboardConfiguration.class, dashboardTask.class, dashboardResult.class, dashboardTestInput.class, dashboardTestExpectation.class);
    }

    /**
     * Return a task factory for creating tasks.
     * @param configuration
     * @return dashboardTaskFactory
     * @throws Exception
     */
    @Override
    protected WorkerTaskFactory<dashboardTask, dashboardTestInput, dashboardTestExpectation> getTaskFactory(TestConfiguration<dashboardTask, dashboardResult, dashboardTestInput, dashboardTestExpectation> configuration) throws Exception {
        return new dashboardTaskFactory(configuration);
    }

    /**
     * Return a result validation processor for validating the worker result is the same as the expected result in the test item.
     * @param configuration
     * @param workerServices
     * @return dashboardResultValidationProcessor
     */
    @Override
    protected ResultProcessor getTestResultProcessor(TestConfiguration<dashboardTask, dashboardResult, dashboardTestInput, dashboardTestExpectation> configuration, WorkerServices workerServices) {
        return new dashboardResultValidationProcessor(workerServices);
    }

    /**
     * Return a result preparation provider for preparing test items from YAML files.
     * @param configuration
     * @return dashboardResultPreparationProvider
     */
    @Override
    protected TestItemProvider getDataPreparationItemProvider(TestConfiguration<dashboardTask, dashboardResult, dashboardTestInput, dashboardTestExpectation> configuration) {
        return new dashboardResultPreparationProvider(configuration);
    }

    /**
     * Return a save result processor for generating .testcase and result.content files found in test-data > input folder.
     * @param configuration
     * @param workerServices
     * @return dashboardSaveResultProcessor
     */
    @Override
    protected ResultProcessor getDataPreparationResultProcessor(TestConfiguration<dashboardTask, dashboardResult, dashboardTestInput, dashboardTestExpectation> configuration, WorkerServices workerServices) {
        return new dashboardSaveResultProcessor(configuration, workerServices);
    }

}
