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
package 121212;

import com.hpe.caf.worker.testing.*;
import com.hpe.caf.worker.testing.execution.AbstractTestControllerProvider;

/**
 * Class providing task factory, validation processor, save result processor, result preparation provider for running integration
 * tests.
 */
public class rtfsTestControllerProvider extends AbstractTestControllerProvider<rtfsConfiguration,
        rtfsTask, rtfsResult, rtfsTestInput, rtfsTestExpectation> {

    public rtfsTestControllerProvider() {
        super(rtfsConstants.WORKER_NAME, rtfsConfiguration::getOutputQueue, rtfsConfiguration.class, rtfsTask.class, rtfsResult.class, rtfsTestInput.class, rtfsTestExpectation.class);
    }

    /**
     * Return a task factory for creating tasks.
     * @param configuration
     * @return rtfsTaskFactory
     * @throws Exception
     */
    @Override
    protected WorkerTaskFactory<rtfsTask, rtfsTestInput, rtfsTestExpectation> getTaskFactory(TestConfiguration<rtfsTask, rtfsResult, rtfsTestInput, rtfsTestExpectation> configuration) throws Exception {
        return new rtfsTaskFactory(configuration);
    }

    /**
     * Return a result validation processor for validating the worker result is the same as the expected result in the test item.
     * @param configuration
     * @param workerServices
     * @return rtfsResultValidationProcessor
     */
    @Override
    protected ResultProcessor getTestResultProcessor(TestConfiguration<rtfsTask, rtfsResult, rtfsTestInput, rtfsTestExpectation> configuration, WorkerServices workerServices) {
        return new rtfsResultValidationProcessor(workerServices);
    }

    /**
     * Return a result preparation provider for preparing test items from YAML files.
     * @param configuration
     * @return rtfsResultPreparationProvider
     */
    @Override
    protected TestItemProvider getDataPreparationItemProvider(TestConfiguration<rtfsTask, rtfsResult, rtfsTestInput, rtfsTestExpectation> configuration) {
        return new rtfsResultPreparationProvider(configuration);
    }

    /**
     * Return a save result processor for generating .testcase and result.content files found in test-data > input folder.
     * @param configuration
     * @param workerServices
     * @return rtfsSaveResultProcessor
     */
    @Override
    protected ResultProcessor getDataPreparationResultProcessor(TestConfiguration<rtfsTask, rtfsResult, rtfsTestInput, rtfsTestExpectation> configuration, WorkerServices workerServices) {
        return new rtfsSaveResultProcessor(configuration, workerServices);
    }

}
