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

package com.blazebit.persistence.view.testsuite.correlation.general.model;

import com.blazebit.persistence.testsuite.entity.Version;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.FetchStrategy;
import com.blazebit.persistence.view.MappingCorrelated;
import com.blazebit.persistence.view.testsuite.correlation.model.DocumentCorrelationView;
import com.blazebit.persistence.view.testsuite.correlation.model.SimpleDocumentCorrelatedView;
import com.blazebit.persistence.view.testsuite.correlation.model.SimplePersonCorrelatedSubView;
import com.blazebit.persistence.testsuite.entity.Document;
import com.blazebit.persistence.testsuite.entity.Person;
import com.blazebit.persistence.view.testsuite.correlation.model.SimpleVersionCorrelatedView;

import java.util.Set;

/**
 * Use the association directly. This wasn't possible with Hibernate because of HHH-2772 but is now because we implemented automatic rewriting with #341.
 * We still keep this around to catch possible regressions.
 *
 * @author Christian Beikov
 * @since 1.2.0
 */
@EntityView(Document.class)
public interface DocumentCorrelationViewJoinNormal extends DocumentCorrelationView {

    @MappingCorrelated(correlationBasis = "owner", correlationResult = "id", correlator = OwnerCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Long getCorrelatedOwnerId();

    @MappingCorrelated(correlationBasis = "owner", correlator = OwnerCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Person getCorrelatedOwner();

    @MappingCorrelated(correlationBasis = "owner", correlator = OwnerCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public SimplePersonCorrelatedSubView getCorrelatedOwnerView();

    @MappingCorrelated(correlationBasis = "owner", correlationResult = "id", correlator = OwnerCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<Long> getCorrelatedOwnerIdList();

    @MappingCorrelated(correlationBasis = "owner", correlator = OwnerCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<Person> getCorrelatedOwnerList();

    @MappingCorrelated(correlationBasis = "owner", correlator = OwnerCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<SimplePersonCorrelatedSubView> getCorrelatedOwnerViewList();

    @MappingCorrelated(correlationBasis = "owner", correlationResult = "id", correlator = OwnerRelatedCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<Long> getOwnerRelatedDocumentIds();

    @MappingCorrelated(correlationBasis = "owner", correlator = OwnerRelatedCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<Document> getOwnerRelatedDocuments();

    @MappingCorrelated(correlationBasis = "owner", correlator = OwnerRelatedCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<SimpleDocumentCorrelatedView> getOwnerRelatedDocumentViews();

    @MappingCorrelated(correlationBasis = "owner", correlationResult = "id", correlator = OwnerOnlyRelatedCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<Long> getOwnerOnlyRelatedDocumentIds();

    @MappingCorrelated(correlationBasis = "owner", correlator = OwnerOnlyRelatedCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<Document> getOwnerOnlyRelatedDocuments();

    @MappingCorrelated(correlationBasis = "owner", correlator = OwnerOnlyRelatedCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<SimpleDocumentCorrelatedView> getOwnerOnlyRelatedDocumentViews();

    @MappingCorrelated(correlationBasis = "this", correlator = ThisCorrelationProviderNormal.class, correlationResult = "id", fetch = FetchStrategy.JOIN)
    public Long getThisCorrelatedId();

    @MappingCorrelated(correlationBasis = "this", correlator = ThisCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Document getThisCorrelatedEntity();

    @MappingCorrelated(correlationBasis = "this", correlator = ThisCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public SimpleDocumentCorrelatedView getThisCorrelatedView();

    @MappingCorrelated(correlationBasis = "this", correlator = ThisCorrelationProviderNormal.class, correlationResult = "id", fetch = FetchStrategy.JOIN)
    public Set<Long> getThisCorrelatedIdList();

    @MappingCorrelated(correlationBasis = "this", correlator = ThisCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<Document> getThisCorrelatedEntityList();

    @MappingCorrelated(correlationBasis = "this", correlator = ThisCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<SimpleDocumentCorrelatedView> getThisCorrelatedViewList();

    @MappingCorrelated(correlationBasis = "this", correlationResult = "versions.id", correlator = ThisCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<Long> getThisCorrelatedEmptyIdList();

    @MappingCorrelated(correlationBasis = "this", correlationResult = "versions", correlator = ThisCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<Version> getThisCorrelatedEmptyEntityList();

    @MappingCorrelated(correlationBasis = "this", correlationResult = "versions", correlator = ThisCorrelationProviderNormal.class, fetch = FetchStrategy.JOIN)
    public Set<SimpleVersionCorrelatedView> getThisCorrelatedEmptyViewList();

}
