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

import com.hpe.caf.worker.testing.TestConfiguration;
import com.hpe.caf.worker.testing.TestItem;
import com.hpe.caf.worker.testing.preparation.PreparationItemProvider;

import java.nio.file.Path;

/**
 * Result preparation provider for preparing test items.
 * Generates Test items from the yaml serialised test case files.
 */
public class fraud-detectionResultPreparationProvider  extends PreparationItemProvider<fraud-detectionTask, fraud-detectionResult, fraud-detectionTestInput, fraud-detectionTestExpectation> {

    public fraud-detectionResultPreparationProvider(TestConfiguration<fraud-detectionTask, fraud-detectionResult, fraud-detectionTestInput, fraud-detectionTestExpectation> configuration) {
        super(configuration);
    }

    /**
     * Method for generating test items from the yaml testcases.
     * Creates fraud-detectionTestInput and fraud-detectionTestExpectation objects (which contain fraud-detectionTask and fraud-detectionResult).
     * The fraud-detectionTask found in fraud-detectionTestInput is fed into the worker for the integration test, and the result is
     * compared with the fraud-detectionResult found in the fraud-detectionTestExpectation.
     * @param inputFile
     * @param expectedFile
     * @return TestItem
     * @throws Exception
     */
    @Override
    protected TestItem createTestItem(Path inputFile, Path expectedFile) throws Exception {
        TestItem<fraud-detectionTestInput, fraud-detectionTestExpectation> item = super.createTestItem(inputFile, expectedFile);
        fraud-detectionTask task = getTaskTemplate();

        // if the task is null, put in default values
        if(task==null){
            task=new fraud-detectionTask();
            task.action = fraud-detectionAction.VERBATIM;
        }

        item.getInputData().setTask(task);
        return item;
    }
}
