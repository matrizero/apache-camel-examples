package com.matrizero.camelrestdsl.transforms;

import com.matrizero.camelrestdsl.model.Contract;

public class UpperCaseContentTransformer {

    public Contract TransformContent(Contract c){
        Contract contract = c;
        contract.setContractName(c.getContractName().toUpperCase());
        return contract;
    }
}
