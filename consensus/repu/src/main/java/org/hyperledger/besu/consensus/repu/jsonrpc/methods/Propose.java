/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.consensus.repu.jsonrpc.methods;

import org.hyperledger.besu.consensus.common.validator.ValidatorProvider;
import org.hyperledger.besu.consensus.repu.RepuBlockInterface;
import org.hyperledger.besu.datatypes.Address;
import org.hyperledger.besu.ethereum.api.jsonrpc.RpcMethod;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.JsonRpcRequestContext;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.methods.JsonRpcMethod;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.response.JsonRpcError;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.response.JsonRpcErrorResponse;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.response.JsonRpcResponse;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.response.JsonRpcSuccessResponse;

import static com.google.common.base.Preconditions.checkState;

public class Propose implements JsonRpcMethod {
  private final ValidatorProvider validatorProvider;

  public Propose(final ValidatorProvider validatorProvider) {
    this.validatorProvider = validatorProvider;
  }

  @Override
  public String getName() {
    return RpcMethod.CLIQUE_PROPOSE.getMethodName();
  }

  @Override
  public JsonRpcResponse response(final JsonRpcRequestContext requestContext) {
    checkState(
        validatorProvider.getVoteProviderAtHead().isPresent(), "Repu requires a vote provider");
    final Address address = requestContext.getRequiredParameter(0, Address.class);
    final Boolean auth = requestContext.getRequiredParameter(1, Boolean.class);
    if (address.equals(RepuBlockInterface.NO_VOTE_SUBJECT)) {
      return new JsonRpcErrorResponse(
          requestContext.getRequest().getId(), JsonRpcError.INVALID_REQUEST);
    }

    if (auth) {
      validatorProvider.getVoteProviderAtHead().get().authVote(address);
    } else {
      validatorProvider.getVoteProviderAtHead().get().dropVote(address);
    }
    // Return true regardless, the vote is always recorded
    return new JsonRpcSuccessResponse(requestContext.getRequest().getId(), true);
  }
}
