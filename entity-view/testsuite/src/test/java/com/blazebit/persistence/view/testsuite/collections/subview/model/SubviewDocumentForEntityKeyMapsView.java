/*
 * Copyright 2014 - 2022 Blazebit.
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

package com.blazebit.persistence.view.testsuite.collections.subview.model;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.Mapping;
import com.blazebit.persistence.testsuite.entity.DocumentForEntityKeyMaps;

import java.util.Map;

/**
 * @author Moritz Becker
 * @since 1.2.0
 */
@EntityView(DocumentForEntityKeyMaps.class)
public interface SubviewDocumentForEntityKeyMapsView {

    @IdMapping
    public Long getId();

    public String getName();

    @Mapping("contactDocuments")
    public abstract Map<SubviewPersonForEntityKeyMapsView, SubviewSimpleDocumentForEntityKeyMapsView> getContactDocuments();
}
