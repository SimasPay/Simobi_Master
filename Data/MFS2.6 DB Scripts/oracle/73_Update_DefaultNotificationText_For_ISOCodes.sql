update notification set text = '$(BankName) Sorry, transaction on $(TransactionDateTime) failed. An error occurred while processing your request. $(Reason) Info, call $(ContactCenterNo). REF: $(TransactionID)' where code='89';

commit;