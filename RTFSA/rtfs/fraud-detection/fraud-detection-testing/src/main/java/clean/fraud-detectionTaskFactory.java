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

import com.hpe.caf.util.ref.ReferencedData;
import com.hpe.caf.worker.testing.FileInputWorkerTaskFactory;
import com.hpe.caf.worker.testing.TestConfiguration;
import com.hpe.caf.worker.testing.TestItem;

/**
 * Task factory for creating tasks from test item.
 */
public class fraud-detectionTaskFactory extends FileInputWorkerTaskFactory<fraud-detectionTask, fraud-detectionTestInput, fraud-detectionTestExpectation> {
    public fraud-detectionTaskFactory(TestConfiguration configuration) throws Exception {
        super(configuration);
    }

    /**
     * Creates a task from a test item (the test item is generated from the yaml test case).
     * @param testItem
     * @param sourceData
     * @return fraud-detectionTask
     */
    @Override
    protected fraud-detectionTask createTask(TestItem<fraud-detectionTestInput, fraud-detectionTestExpectation> testItem, ReferencedData sourceData) {
        fraud-detectionTask task = testItem.getInputData().getTask();

        //setting task source data to the source data parameter.
        task.sourceData = sourceData;
        task.datastorePartialReference = getContainerId();
        task.action = testItem.getInputData().getTask().action;

        return task;
    }

    @Override
    public String getWorkerName() {
        return fraud-detectionConstants.WORKER_NAME;
    }

    @Override
    public int getApiVersion() {
        return fraud-detectionConstants.WORKER_API_VER;
    }
}
