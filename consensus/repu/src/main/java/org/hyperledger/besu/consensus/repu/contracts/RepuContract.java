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
  public static final String BINARY = "6080604052600a6009556001600a553480156200001b57600080fd5b5060405162002a1638038062002a168339818101604052810190620000419190620006b4565b62000052816200011960201b60201c565b62000077732ed64d60e50f820b240eb5905b0a73848b2506d66200011960201b60201c565b62000087620001c360201b60201c565b600060068190555081600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555033600b60006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505062000881565b6001819080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555050565b60005b600180549050811015620002bf576200022660018281548110620001ef57620001ee620006fb565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16620002ea60201b60201c565b6000806001848154811062000240576200023f620006fb565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508080620002b69062000763565b915050620001c6565b50620002d06200038a60201b60201c565b60019080519060200190620002e79291906200059c565b50565b6000600a54600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020546200033b9190620007df565b600954670de0b6b3a76400008473ffffffffffffffffffffffffffffffffffffffff16316200036b9190620007df565b620003779190620007df565b62000383919062000817565b9050919050565b6060600060018054905067ffffffffffffffff811115620003b057620003af62000852565b5b604051908082528060200260200182016040528015620003df5781602001602082028036833780820191505090505b509050600060018054905067ffffffffffffffff81111562000406576200040562000852565b5b604051908082528060200260200182016040528015620004355781602001602082028036833780820191505090505b50905060005b600180549050811015620005935760008060018381548110620004635762000462620006fb565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054838281518110620004df57620004de620006fb565b5b60200260200101818152505060018181548110620005025762000501620006fb565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828281518110620005435762000542620006fb565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff168152505080806200058a9062000763565b9150506200043b565b50809250505090565b82805482825590600052602060002090810192821562000618579160200282015b82811115620006175782518260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555091602001919060010190620005bd565b5b5090506200062791906200062b565b5090565b5b80821115620006465760008160009055506001016200062c565b5090565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006200067c826200064f565b9050919050565b6200068e816200066f565b81146200069a57600080fd5b50565b600081519050620006ae8162000683565b92915050565b60008060408385031215620006ce57620006cd6200064a565b5b6000620006de858286016200069d565b9250506020620006f1858286016200069d565b9150509250929050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000819050919050565b6000620007708262000759565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203620007a557620007a46200072a565b5b600182019050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b6000620007ec8262000759565b9150620007f98362000759565b9250826200080c576200080b620007b0565b5b828204905092915050565b6000620008248262000759565b9150620008318362000759565b92508282019050808211156200084c576200084b6200072a565b5b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b61218580620008916000396000f3fe608060405234801561001057600080fd5b506004361061010b5760003560e01c8063933a9ce8116100a2578063b872953e11610071578063b872953e1461027e578063b9137cca146102ae578063bdf3e088146102cc578063cdd72253146102e8578063facd743b146103065761010b565b8063933a9ce81461020a5780639cbfc76514610228578063b28fc60014610244578063b7ab4db5146102605761010b565b80633ea4fa47116100de5780633ea4fa47146101865780637b778b70146101a25780637ed21005146101be578063899c7184146101da5761010b565b806306a49fce146101105780631ba5eec01461012e5780632945400c146101385780632e97766d14610168575b600080fd5b610118610336565b6040516101259190611b10565b60405180910390f35b6101366103c4565b005b610152600480360381019061014d9190611b63565b61040e565b60405161015f9190611ba9565b60405180910390f35b610170610426565b60405161017d9190611ba9565b60405180910390f35b6101a0600480360381019061019b9190611bf0565b61042e565b005b6101bc60048036038101906101b79190611c1d565b610492565b005b6101d860048036038101906101d39190611c1d565b61078c565b005b6101f460048036038101906101ef9190611b63565b6107be565b6040516102019190611ba9565b60405180910390f35b6102126107d6565b60405161021f9190611c6c565b60405180910390f35b610242600480360381019061023d9190611b63565b610800565b005b61025e60048036038101906102599190611bf0565b610a1a565b005b610268610a7e565b6040516102759190611b10565b60405180910390f35b61029860048036038101906102939190611b63565b610b0c565b6040516102a59190611ba9565b60405180910390f35b6102b6610b24565b6040516102c39190611b10565b60405180910390f35b6102e660048036038101906102e19190611b63565b610d20565b005b6102f0610f00565b6040516102fd9190611b10565b60405180910390f35b610320600480360381019061031b9190611b63565b610f8e565b60405161032d9190611ca2565b60405180910390f35b606060038054806020026020016040519081016040528092919081815260200182805480156103ba57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610370575b5050505050905090565b600660008154809291906103d790611cec565b91905055506000600560016103ea610426565b6103f49190611d34565b6103fe9190611d97565b0361040c5761040b61102f565b5b565b60056020528060005260406000206000915090505481565b600043905090565b600b60009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461048857600080fd5b8060098190555050565b60048054905061052833600480548060200260200160405190810160405280929190818152602001828054801561051e57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116104d4575b505050505061106b565b14610568576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161055f90611e25565b60405180910390fd5b818073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16036105d7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105ce90611e91565b60405180910390fd5b81600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055506004339080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205403610729576003839080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b610732336110f1565b600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282546107809190611eb1565b92505081905550505050565b6107946103c4565b600060056107a0610426565b6107aa9190611d97565b036107ba576107b98282610492565b5b5050565b60006020528060005260406000206000915090505481565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b600061089282600180548060200260200160405190810160405280929190818152602001828054801561088857602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001906001019080831161083e575b505050505061106b565b905060018054905081106108db576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016108d290611f31565b60405180910390fd5b60018080805490506108ed9190611d34565b815481106108fe576108fd611f51565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166001828154811061093d5761093c611f51565b5b9060005260206000200160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600180548061099757610996611f80565b5b6001900381819060005260206000200160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905590556000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009055610a16611189565b5050565b600b60009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610a7457600080fd5b80600a8190555050565b60606001805480602002602001604051908101604052809291908181526020018280548015610b0257602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610ab8575b5050505050905090565b60026020528060005260406000206000915090505481565b60606000600180549050600654610b3b9190611d97565b905060008060018054905067ffffffffffffffff811115610b5f57610b5e611faf565b5b604051908082528060200260200182016040528015610b8d5781602001602082028036833780820191505090505b5090505b600180549050831015610c4b5760018381548110610bb257610bb1611f51565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16818381518110610bf057610bef611f51565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508280610c3590611cec565b9350508180610c4390611cec565b925050610b91565b600092505b600180549050600654610c639190611d97565b831015610d175760018381548110610c7e57610c7d611f51565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16818381518110610cbc57610cbb611f51565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff16815250508280610d0190611cec565b9350508180610d0f90611cec565b925050610c50565b80935050505090565b8060008173ffffffffffffffffffffffffffffffffffffffff1663933a9ce86040518163ffffffff1660e01b8152600401602060405180830381865afa158015610d6e573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610d929190611ff3565b90508073ffffffffffffffffffffffffffffffffffffffff16600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614610e24576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e1b90612092565b60405180910390fd5b82610e2e81611294565b610e6d576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e64906120fe565b60405180910390fd5b600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638ed8f67f856040518263ffffffff1660e01b8152600401610ec89190611c6c565b600060405180830381600087803b158015610ee257600080fd5b505af1158015610ef6573d6000803e3d6000fd5b5050505050505050565b60606004805480602002602001604051908101604052809291908181526020018280548015610f8457602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610f3a575b5050505050905090565b600060018054905061102683600180548060200260200160405190810160405280929190818152602001828054801561101c57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610fd2575b505050505061106b565b14159050919050565b60006110396112b7565b9050600360006110499190611958565b600460006110579190611958565b611060816114b2565b611068611189565b50565b600080600090505b82518110156110e5578373ffffffffffffffffffffffffffffffffffffffff168382815181106110a6576110a5611f51565b5b602002602001015173ffffffffffffffffffffffffffffffffffffffff16036110d257809150506110eb565b80806110dd90611cec565b915050611073565b50815190505b92915050565b6000600a54600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611140919061211e565b600954670de0b6b3a76400008473ffffffffffffffffffffffffffffffffffffffff163161116e919061211e565b611178919061211e565b6111829190611eb1565b9050919050565b60005b600180549050811015611273576111e0600182815481106111b0576111af611f51565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166110f1565b600080600184815481106111f7576111f6611f51565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550808061126b90611cec565b91505061118c565b5061127c6116b4565b60019080519060200190611291929190611979565b50565b6000808273ffffffffffffffffffffffffffffffffffffffff163b119050919050565b6060600060038054905067ffffffffffffffff8111156112da576112d9611faf565b5b6040519080825280602002602001820160405280156113085781602001602082028036833780820191505090505b509050600060038054905067ffffffffffffffff81111561132c5761132b611faf565b5b60405190808252806020026020018201604052801561135a5781602001602082028036833780820191505090505b50905060005b6003805490508110156114a957600260006003838154811061138557611384611f51565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020548382815181106113fe576113fd611f51565b5b6020026020010181815250506003818154811061141e5761141d611f51565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1682828151811061145c5761145b611f51565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff168152505080806114a190611cec565b915050611360565b50809250505090565b60028151106114ce57600160006114c99190611958565b611603565b60005b8151811015611601576000600560008484815181106114f3576114f2611f51565b5b602002602001015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205411156115ee5761155f82828151811061155257611551611f51565b5b6020026020010151610f8e565b1561158c5761158782828151811061157a57611579611f51565b5b6020026020010151610800565b6115ed565b60028160018054905061159f9190611eb1565b036115ec5760018054806115b6576115b5611f80565b5b6001900381819060005260206000200160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905590555b5b5b80806115f990611cec565b9150506114d1565b505b60005b8151811080156116165750600281105b156116b05761163e82828151811061163157611630611f51565b5b60200260200101516118ae565b60006002600084848151811061165757611656611f51565b5b602002602001015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555080806116a890611cec565b915050611606565b5050565b6060600060018054905067ffffffffffffffff8111156116d7576116d6611faf565b5b6040519080825280602002602001820160405280156117055781602001602082028036833780820191505090505b509050600060018054905067ffffffffffffffff81111561172957611728611faf565b5b6040519080825280602002602001820160405280156117575781602001602082028036833780820191505090505b50905060005b6001805490508110156118a5576000806001838154811061178157611780611f51565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020548382815181106117fa576117f9611f51565b5b6020026020010181815250506001818154811061181a57611819611f51565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1682828151811061185857611857611f51565b5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050808061189d90611cec565b91505061175d565b50809250505090565b6001819080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555050565b50805460008255906000526020600020908101906119769190611a03565b50565b8280548282559060005260206000209081019282156119f2579160200282015b828111156119f15782518260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555091602001919060010190611999565b5b5090506119ff9190611a03565b5090565b5b80821115611a1c576000816000905550600101611a04565b5090565b600081519050919050565b600082825260208201905092915050565b6000819050602082019050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000611a7782611a4c565b9050919050565b611a8781611a6c565b82525050565b6000611a998383611a7e565b60208301905092915050565b6000602082019050919050565b6000611abd82611a20565b611ac78185611a2b565b9350611ad283611a3c565b8060005b83811015611b03578151611aea8882611a8d565b9750611af583611aa5565b925050600181019050611ad6565b5085935050505092915050565b60006020820190508181036000830152611b2a8184611ab2565b905092915050565b600080fd5b611b4081611a6c565b8114611b4b57600080fd5b50565b600081359050611b5d81611b37565b92915050565b600060208284031215611b7957611b78611b32565b5b6000611b8784828501611b4e565b91505092915050565b6000819050919050565b611ba381611b90565b82525050565b6000602082019050611bbe6000830184611b9a565b92915050565b611bcd81611b90565b8114611bd857600080fd5b50565b600081359050611bea81611bc4565b92915050565b600060208284031215611c0657611c05611b32565b5b6000611c1484828501611bdb565b91505092915050565b60008060408385031215611c3457611c33611b32565b5b6000611c4285828601611b4e565b9250506020611c5385828601611bdb565b9150509250929050565b611c6681611a6c565b82525050565b6000602082019050611c816000830184611c5d565b92915050565b60008115159050919050565b611c9c81611c87565b82525050565b6000602082019050611cb76000830184611c93565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000611cf782611b90565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203611d2957611d28611cbd565b5b600182019050919050565b6000611d3f82611b90565b9150611d4a83611b90565b9250828203905081811115611d6257611d61611cbd565b5b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b6000611da282611b90565b9150611dad83611b90565b925082611dbd57611dbc611d68565b5b828206905092915050565b600082825260208201905092915050565b7f566f746520616c72656164792072656769737465726564000000000000000000600082015250565b6000611e0f601783611dc8565b9150611e1a82611dd9565b602082019050919050565b60006020820190508181036000830152611e3e81611e02565b9050919050565b7f41206e6f64652063616e206e6f7420766f74652068696d73656c660000000000600082015250565b6000611e7b601b83611dc8565b9150611e8682611e45565b602082019050919050565b60006020820190508181036000830152611eaa81611e6e565b9050919050565b6000611ebc82611b90565b9150611ec783611b90565b9250828201905080821115611edf57611ede611cbd565b5b92915050565b7f56616c696461746f72206e6f7420666f756e642e000000000000000000000000600082015250565b6000611f1b601483611dc8565b9150611f2682611ee5565b602082019050919050565b60006020820190508181036000830152611f4a81611f0e565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b600081519050611fed81611b37565b92915050565b60006020828403121561200957612008611b32565b5b600061201784828501611fde565b91505092915050565b7f436f6e74726163742070726f78792061646472657373206973206e6f7420636f60008201527f7272656374000000000000000000000000000000000000000000000000000000602082015250565b600061207c602583611dc8565b915061208782612020565b604082019050919050565b600060208201905081810360008301526120ab8161206f565b9050919050565b7f41646472657373206973206e6f74206120636f6e747261637400000000000000600082015250565b60006120e8601983611dc8565b91506120f3826120b2565b602082019050919050565b60006020820190508181036000830152612117816120db565b9050919050565b600061212982611b90565b915061213483611b90565b92508261214457612143611d68565b5b82820490509291505056fea2646970667358221220571f077abf6c2bde05275b74c87097e1b3408ed22c4818dc430e0d12ee160ed664736f6c63430008120033";
  public static final String FUNC_NEXTVALIDATORS = "nextValidators";
  public static final String FUNC_ISVALIDATOR = "isValidator";
  public static final String FUNC_GETVALIDATORS = "getValidators";
  public static final String FUNC_VOTEVALIDATOR = "voteValidator";
  public static final String FUNC_NEXTTURN = "nextTurn";
  public static final String FUNC_NEXTTURNANDVOTE = "nextTurnAndVote";
  public static final String FUNC_GETBLOCK = "getBlock";
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

  private RemoteFunctionCall<TransactionReceipt> nextTurnAndVoteCall(String address, BigInteger nonce) {
    final org.web3j.abi.datatypes.Function function =
            new org.web3j.abi.datatypes.Function(
                    FUNC_NEXTTURNANDVOTE,
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

  private RemoteFunctionCall<BigInteger> getBlockCall() {
    final org.web3j.abi.datatypes.Function function =
            new org.web3j.abi.datatypes.Function(
                    FUNC_GETBLOCK,
                    Collections.emptyList(),
                    Collections.singletonList(new TypeReference<Uint256>() {}));
    return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

  public void nextTurnAndVote(String address, BigInteger nonce) throws Exception { this.nextTurnAndVoteCall(address, nonce).send(); }

  public void nextTurn() throws Exception { this.nextTurnCall().send(); }

  public long getBlock() throws Exception { return this.getBlockCall().send().longValue(); }




}
