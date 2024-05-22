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

import com.hpe.caf.util.ref.ReferencedData;

import javax.validation.constraints.NotNull;

/**
 * The result class of the worker, containing a worker status and a ReferencedData object for textData.
 */
public final class creditcardproducerResult {

    /**
     * Worker specific return code.
     */
    @NotNull
    public creditcardproducerStatus workerStatus;

    /**
     * Result file is stored in datastore and accessed using this ReferencedData object.
     */
    public ReferencedData textData;
}