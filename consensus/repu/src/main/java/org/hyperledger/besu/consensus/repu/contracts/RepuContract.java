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
package org.hyperledger.besu.consensus.repu.contracts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Auto generated code.
 *
 * <p><strong>Do not modify!</strong>
 *
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the <a
 * href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
public class RepuContract extends Contract {
  public static final String BINARY = "60806040526127106009556001600a553480156200001c57600080fd5b5060405162002637380380620026378339818101604052810190620000429190620003cd565b62000053816200011a60201b60201c565b62000078732ed64d60e50f820b240eb5905b0a73848b2506d66200011a60201b60201c565b62000088620001c460201b60201c565b600060068190555081600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555033600b60006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050506200056b565b6001819080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555050565b60005b600180549050811015620002c0576200022760018281548110620001f057620001ef62000414565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16620002c360201b60201c565b6000806001848154811062000241576200024062000414565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508080620002b7906200047c565b915050620001c7565b50565b6000600a54600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054620003149190620004f8565b600954670de0b6b3a76400008473ffffffffffffffffffffffffffffffffffffffff1631620003449190620004f8565b620003509190620004f8565b6200035c919062000530565b9050919050565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000620003958262000368565b9050919050565b620003a78162000388565b8114620003b357600080fd5b50565b600081519050620003c7816200039c565b92915050565b60008060408385031215620003e757620003e662000363565b5b6000620003f785828601620003b6565b92505060206200040a85828601620003b6565b9150509250929050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000819050919050565b6000620004898262000472565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203620004be57620004bd62000443565b5b600182019050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b6000620005058262000472565b9150620005128362000472565b925082620005255762000524620004c9565b5b828204905092915050565b60006200053d8262000472565b91506200054a8362000472565b925082820190508082111562000565576200056462000443565b5b92915050565b6120bc806200057b6000396000f3fe608060405234801561001057600080fd5b50600436106101005760003560e01c80639cbfc76511610097578063b9137cca11610066578063b9137cca14610287578063bdf3e088146102a5578063cdd72253146102c1578063facd743b146102df57610100565b80639cbfc76514610201578063b28fc6001461021d578063b7ab4db514610239578063b872953e1461025757610100565b80633ea4fa47116100d35780633ea4fa471461017b5780637b778b7014610197578063899c7184146101b3578063933a9ce8146101e357610100565b806306a49fce146101055780631ba5eec0146101235780632945400c1461012d5780632e97766d1461015d575b600080fd5b61010d61030f565b60405161011a9190611a1e565b60405180910390f35b61012b61039d565b005b61014760048036038101906101429190611a71565b6103e7565b6040516101549190611ab7565b60405180910390f35b6101656103ff565b6040516101729190611ab7565b60405180910390f35b61019560048036038101906101909190611afe565b610407565b005b6101b160048036038101906101ac9190611b2b565b61046b565b005b6101cd60048036038101906101c89190611a71565b610709565b6040516101da9190611ab7565b60405180910390f35b6101eb610721565b6040516101f89190611b7a565b60405180910390f35b61021b60048036038101906102169190611a71565b61074b565b005b61023760048036038101906102329190611afe565b610965565b005b6102416109c9565b60405161024e9190611a1e565b60405180910390f35b610271600480360381019061026c9190611a71565b610a57565b60405161027e9190611ab7565b60405180910390f35b61028f610a6f565b60405161029c9190611a1e565b60405180910390f35b6102bf60048036038101906102ba9190611a71565b610c6b565b005b6102c9610e4b565b6040516102d69190611a1e565b60405180910390f35b6102f960048036038101906102f49190611a71565b610ed9565b6040516103069190611bb0565b60405180910390f35b6060600380548060200260200160405190810160405280929190818152602001828054801561039357602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610349575b5050505050905090565b6000600560026103ab6103ff565b6103b59190611bfa565b6103bf9190611c5d565b036103cd576103cc610f7a565b5b600660008154809291906103e090611c8e565b9190505550565b60056020528060005260406000206000915090505481565b600043905090565b600b60009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461046157600080fd5b8060098190555050565b6004805490506105013360048054806020026020016040519081016040528092919081815260200182805480156104f757602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116104ad575b5050505050610fb6565b14610541576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161053890611d33565b60405180910390fd5b61054961103c565b80600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055506004339080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600260008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020540361069b576003829080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906106eb90611c8e565b9190505550600480805490501061070557610704610f7a565b5b5050565b60006020528060005260406000206000915090505481565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b60006107dd8260018054806020026020016040519081016040528092919081815260200182805480156107d357602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610789575b5050505050610fb6565b90506001805490508110610826576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161081d90611d9f565b60405180910390fd5b60018080805490506108389190611bfa565b8154811061084957610848611dbf565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166001828154811061088857610887611dbf565b5b9060005260206000200160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018054806108e2576108e1611dee565b5b6001900381819060005260206000200160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905590556000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009055610961611099565b5050565b600b60009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146109bf57600080fd5b80600a8190555050565b60606001805480602002602001604051908101604052809291908181526020018280548015610a4d57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610a03575b5050505050905090565b60026020528060005260406000206000915090505481565b60606000600180549050600654610a869190611c5d565b905060008060018054905067ffffffffffffffff811115610aaa57610aa9611e1d565b5b604051908082528060200260200182016040528015610ad85781602001602082028036833780820191505090505b5090505b600180549050831015610b965760018381548110610afd57610afc611dbf565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16818381518110610b3b57610b3a611dbf565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508280610b8090611c8e565b9350508180610b8e90611c8e565b925050610adc565b600092505b600180549050600654610bae9190611c5d565b831015610c625760018381548110610bc957610bc8611dbf565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16818381518110610c0757610c06611dbf565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508280610c4c90611c8e565b9350508180610c5a90611c8e565b925050610b9b565b80935050505090565b8060008173ffffffffffffffffffffffffffffffffffffffff1663933a9ce86040518163ffffffff1660e01b8152600401602060405180830381865afa158015610cb9573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610cdd9190611e61565b90508073ffffffffffffffffffffffffffffffffffffffff16600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614610d6f576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610d6690611f00565b60405180910390fd5b82610d7981611186565b610db8576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610daf90611f6c565b60405180910390fd5b600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638ed8f67f856040518263ffffffff1660e01b8152600401610e139190611b7a565b600060405180830381600087803b158015610e2d57600080fd5b505af1158015610e41573d6000803e3d6000fd5b5050505050505050565b60606004805480602002602001604051908101604052809291908181526020018280548015610ecf57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610e85575b5050505050905090565b6000600180549050610f71836001805480602002602001604051908101604052809291908181526020018280548015610f6757602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610f1d575b5050505050610fb6565b14159050919050565b6000610f846111a9565b905060036000610f9491906118f0565b60046000610fa291906118f0565b610fab816113be565b610fb3611099565b50565b600080600090505b8251811015611030578373ffffffffffffffffffffffffffffffffffffffff16838281518110610ff157610ff0611dbf565b5b602002602001015173ffffffffffffffffffffffffffffffffffffffff160361101d5780915050611036565b808061102890611c8e565b915050610fbe565b50815190505b92915050565b6000600560014361104d9190611bfa565b6110579190611c5d565b14611097576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161108e90611fd8565b60405180910390fd5b565b60005b600180549050811015611183576110f0600182815481106110c0576110bf611dbf565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16611544565b6000806001848154811061110757611106611dbf565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550808061117b90611c8e565b91505061109c565b50565b6000808273ffffffffffffffffffffffffffffffffffffffff163b119050919050565b6060600060038054905067ffffffffffffffff8111156111cc576111cb611e1d565b5b6040519080825280602002602001820160405280156111fa5781602001602082028036833780820191505090505b509050600060038054905067ffffffffffffffff81111561121e5761121d611e1d565b5b60405190808252806020026020018201604052801561124c5781602001602082028036833780820191505090505b50905060005b60038054905081101561139b57600260006003838154811061127757611276611dbf565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020548382815181106112f0576112ef611dbf565b5b602002602001018181525050600381815481106113105761130f611dbf565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1682828151811061134e5761134d611dbf565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050808061139390611c8e565b915050611252565b506113b682826000600185516113b19190611bfa565b6115dc565b809250505090565b60028151106113da57600160006113d591906118f0565b611493565b60005b8151811015611491576114098282815181106113fc576113fb611dbf565b5b6020026020010151610ed9565b156114365761143182828151811061142457611423611dbf565b5b602002602001015161074b565b61147e565b600180548061144857611447611dee565b5b6001900381819060005260206000200160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905590555b808061148990611c8e565b9150506113dd565b505b60005b8151811080156114a65750600281105b15611540576114ce8282815181106114c1576114c0611dbf565b5b6020026020010151611846565b6000600260008484815181106114e7576114e6611dbf565b5b602002602001015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550808061153890611c8e565b915050611496565b5050565b6000600a54600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020546115939190611ff8565b600954670de0b6b3a76400008473ffffffffffffffffffffffffffffffffffffffff16316115c19190611ff8565b6115cb9190611ff8565b6115d59190612029565b9050919050565b600082905060008290508082036115f4575050611840565b600086600286866116059190611bfa565b61160f9190611ff8565b8661161a9190612029565b8151811061162b5761162a611dbf565b5b602002602001015190505b818311611812575b8087848151811061165257611651611dbf565b5b6020026020010151111561167357828061166b90611c8e565b93505061163e565b5b86828151811061168757611686611dbf565b5b60200260200101518111156116a95781806116a19061205d565b925050611674565b81831161180d578682815181106116c3576116c2611dbf565b5b60200260200101518784815181106116de576116dd611dbf565b5b60200260200101518885815181106116f9576116f8611dbf565b5b6020026020010189858151811061171357611712611dbf565b5b602002602001018281525082815250505085828151811061173757611736611dbf565b5b602002602001015186848151811061175257611751611dbf565b5b602002602001015187858151811061176d5761176c611dbf565b5b6020026020010188858151811061178757611786611dbf565b5b602002602001018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152508273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815250505082806117fb90611c8e565b93505081806118099061205d565b9250505b611636565b8185101561182757611826878787856115dc565b5b8383101561183c5761183b878785876115dc565b5b5050505b50505050565b6001819080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555050565b508054600082559060005260206000209081019061190e9190611911565b50565b5b8082111561192a576000816000905550600101611912565b5090565b600081519050919050565b600082825260208201905092915050565b6000819050602082019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006119858261195a565b9050919050565b6119958161197a565b82525050565b60006119a7838361198c565b60208301905092915050565b6000602082019050919050565b60006119cb8261192e565b6119d58185611939565b93506119e08361194a565b8060005b83811015611a115781516119f8888261199b565b9750611a03836119b3565b9250506001810190506119e4565b5085935050505092915050565b60006020820190508181036000830152611a3881846119c0565b905092915050565b600080fd5b611a4e8161197a565b8114611a5957600080fd5b50565b600081359050611a6b81611a45565b92915050565b600060208284031215611a8757611a86611a40565b5b6000611a9584828501611a5c565b91505092915050565b6000819050919050565b611ab181611a9e565b82525050565b6000602082019050611acc6000830184611aa8565b92915050565b611adb81611a9e565b8114611ae657600080fd5b50565b600081359050611af881611ad2565b92915050565b600060208284031215611b1457611b13611a40565b5b6000611b2284828501611ae9565b91505092915050565b60008060408385031215611b4257611b41611a40565b5b6000611b5085828601611a5c565b9250506020611b6185828601611ae9565b9150509250929050565b611b748161197a565b82525050565b6000602082019050611b8f6000830184611b6b565b92915050565b60008115159050919050565b611baa81611b95565b82525050565b6000602082019050611bc56000830184611ba1565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000611c0582611a9e565b9150611c1083611a9e565b9250828203905081811115611c2857611c27611bcb565b5b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b6000611c6882611a9e565b9150611c7383611a9e565b925082611c8357611c82611c2e565b5b828206905092915050565b6000611c9982611a9e565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203611ccb57611cca611bcb565b5b600182019050919050565b600082825260208201905092915050565b7f566f746520616c72656164792072656769737465726564000000000000000000600082015250565b6000611d1d601783611cd6565b9150611d2882611ce7565b602082019050919050565b60006020820190508181036000830152611d4c81611d10565b9050919050565b7f56616c696461746f72206e6f7420666f756e642e000000000000000000000000600082015250565b6000611d89601483611cd6565b9150611d9482611d53565b602082019050919050565b60006020820190508181036000830152611db881611d7c565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b600081519050611e5b81611a45565b92915050565b600060208284031215611e7757611e76611a40565b5b6000611e8584828501611e4c565b91505092915050565b7f436f6e74726163742070726f78792061646472657373206973206e6f7420636f60008201527f7272656374000000000000000000000000000000000000000000000000000000602082015250565b6000611eea602583611cd6565b9150611ef582611e8e565b604082019050919050565b60006020820190508181036000830152611f1981611edd565b9050919050565b7f41646472657373206973206e6f74206120636f6e747261637400000000000000600082015250565b6000611f56601983611cd6565b9150611f6182611f20565b602082019050919050565b60006020820190508181036000830152611f8581611f49565b9050919050565b7f4e6f7420696e20766f746174696f6e2074696d65000000000000000000000000600082015250565b6000611fc2601483611cd6565b9150611fcd82611f8c565b602082019050919050565b60006020820190508181036000830152611ff181611fb5565b9050919050565b600061200382611a9e565b915061200e83611a9e565b92508261201e5761201d611c2e565b5b828204905092915050565b600061203482611a9e565b915061203f83611a9e565b925082820190508082111561205757612056611bcb565b5b92915050565b600061206882611a9e565b91506000820361207b5761207a611bcb565b5b60018203905091905056fea264697066735822122076e173c0bcc0e13076c4a889fd263ec151873141bf05ff0850ebf3d173f8471d64736f6c63430008120033";
  public static final String FUNC_NEXTVALIDATORS = "nextValidators";
  public static final String FUNC_ISVALIDATOR = "isValidator";
  public static final String FUNC_GETVALIDATORS = "getValidators";
  public static final String FUNC_VOTEVALIDATOR = "voteValidator";
  public static final String FUNC_NEXTTURN = "nextTurn";
  public static String INITIAL_ADDRESS = "0xb624d87403ac9f170ea9678a07051adc6fd7dc16";
  public static String INITIAL_VALIDATOR = "0x1c21335d5e5d3f675d7eb7e19e943535555bb291";
  private ProxyContract proxyContract;
  private static final Logger LOG = LoggerFactory.getLogger(RepuContract.class);

  public RepuContract(
          String contractAddress,
          Web3j web3j,
          Credentials credentials,
          ContractGasProvider contractGasProvider,
          ProxyContract proxyContract) {
    this(contractAddress, web3j, credentials, contractGasProvider);
    this.proxyContract = proxyContract;
  }

  public RepuContract(
          String contractAddress,
          Web3j web3j,
          Credentials credentials,
          ContractGasProvider contractGasProvider) {
    super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
  }

  private RemoteFunctionCall<List> nextValidatorsCall() {
    this.checkAddress();
    final org.web3j.abi.datatypes.Function function =
            new org.web3j.abi.datatypes.Function(
                    FUNC_NEXTVALIDATORS,
                    Collections.emptyList(),
                    Collections.singletonList(new TypeReference<DynamicArray<Address>>() {}));
    return new RemoteFunctionCall<List>(
            function,
            () -> {
              List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
              return convertToNative(result);
            });
  }

  private RemoteFunctionCall<Boolean> isValidatorCall(String address) {
    final org.web3j.abi.datatypes.Function function =
            new org.web3j.abi.datatypes.Function(
                    FUNC_ISVALIDATOR,
                    Collections.singletonList(new Address(address)),
                    Collections.singletonList(new TypeReference<Bool>() {}));
    return executeRemoteCallSingleValueReturn(function, Boolean.class);
  }

  private RemoteFunctionCall<List> getValidatorsCall() {
    this.checkAddress();
    final org.web3j.abi.datatypes.Function function =
            new org.web3j.abi.datatypes.Function(
                    FUNC_GETVALIDATORS,
                    Collections.emptyList(),
                    Collections.singletonList(new TypeReference<DynamicArray<Address>>() {}));
    return new RemoteFunctionCall<List>(
            function,
            () -> {
              List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
              return convertToNative(result);
            });
  }

  private RemoteFunctionCall<TransactionReceipt> voteValidatorCall(String address, BigInteger nonce) {
    final org.web3j.abi.datatypes.Function function =
            new org.web3j.abi.datatypes.Function(
                    FUNC_VOTEVALIDATOR,
                    Arrays.asList(new Address(address), new Uint256(nonce)),
                    Collections.emptyList());
    return executeRemoteCallTransaction(function);
  }

  private RemoteFunctionCall<TransactionReceipt> nextTurnCall() {
    this.checkAddress();
    final org.web3j.abi.datatypes.Function function =
            new org.web3j.abi.datatypes.Function(
                    FUNC_NEXTTURN,
                    Collections.emptyList(),
                    Collections.emptyList());
    return executeRemoteCallTransaction(function);
  }

  public static RemoteCall<RepuContract> deploy(
          Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
    return deployRemoteCall(
            RepuContract.class,
            web3j,
            credentials,
            contractGasProvider,
            BINARY,
            FunctionEncoder.encodeConstructor(Arrays.asList(new Address(ProxyContract.ADDRESS), new Address(INITIAL_VALIDATOR))));
  }

  public void setProxyContract(ProxyContract proxyContract) {
    this.proxyContract = proxyContract;
  }

  private void checkAddress(){
    if(!Objects.equals(proxyContract.getContractAddress(), this.getContractAddress())) {
      try {
        this.setContractAddress(proxyContract.getConsensusAddress());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  public List<String> nextValidators() throws Exception { return this.nextValidatorsCall().send(); }

  public Boolean isValidator(String address) throws Exception { return this.isValidatorCall(address).send(); }

  public List<String> getValidators() throws Exception { return this.getValidatorsCall().send(); }

  public void voteValidator(String address, BigInteger nonce) throws Exception { this.voteValidatorCall(address, nonce).send(); }

  public void nextTurn() throws Exception { this.nextTurnCall().send(); }


}
