package com.cotacao.projetoCotacao.Exception;
import com.cotacao.projetoCotacao.Util.MessageUtil;

@SuppressWarnings("serial")
public class NotFound extends RuntimeException{
	public NotFound() {
		super(MessageUtil.NO_RECORDS_FOUND);
	}

}
