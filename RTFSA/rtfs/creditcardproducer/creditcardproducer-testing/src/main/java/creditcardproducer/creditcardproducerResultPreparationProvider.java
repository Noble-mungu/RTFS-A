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

import com.hpe.caf.worker.testing.TestConfiguration;
import com.hpe.caf.worker.testing.TestItem;
import com.hpe.caf.worker.testing.preparation.PreparationItemProvider;

import java.nio.file.Path;

/**
 * Result preparation provider for preparing test items.
 * Generates Test items from the yaml serialised test case files.
 */
public class creditcardproducerResultPreparationProvider  extends PreparationItemProvider<creditcardproducerTask, creditcardproducerResult, creditcardproducerTestInput, creditcardproducerTestExpectation> {

    public creditcardproducerResultPreparationProvider(TestConfiguration<creditcardproducerTask, creditcardproducerResult, creditcardproducerTestInput, creditcardproducerTestExpectation> configuration) {
        super(configuration);
    }

    /**
     * Method for generating test items from the yaml testcases.
     * Creates creditcardproducerTestInput and creditcardproducerTestExpectation objects (which contain creditcardproducerTask and creditcardproducerResult).
     * The creditcardproducerTask found in creditcardproducerTestInput is fed into the worker for the integration test, and the result is
     * compared with the creditcardproducerResult found in the creditcardproducerTestExpectation.
     * @param inputFile
     * @param expectedFile
     * @return TestItem
     * @throws Exception
     */
    @Override
    protected TestItem createTestItem(Path inputFile, Path expectedFile) throws Exception {
        TestItem<creditcardproducerTestInput, creditcardproducerTestExpectation> item = super.createTestItem(inputFile, expectedFile);
        creditcardproducerTask task = getTaskTemplate();

        // if the task is null, put in default values
        if(task==null){
            task=new creditcardproducerTask();
            task.action = creditcardproducerAction.VERBATIM;
        }

        item.getInputData().setTask(task);
        return item;
    }
}
