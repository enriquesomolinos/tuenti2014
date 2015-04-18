package com.tuenti.challenge7.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tuenti.challenge7.model.Call;

// TODO: Auto-generated Javadoc
/**
 * The Class CallsColletion.
 * Contiene toda la información clasificada de las llamadas de tal manera
 * que cada llamada aparece en la lista de los dos telefonos.
 */
public class CallsColletion {

	/** The calls. */
	private Map<Long, List<Call>> calls = new HashMap<Long, List<Call>>();

	

	/** The calls colletion. */
	private static CallsColletion callsColletion;

	/**
	 * Gets the single instance of CallsColletion.
	 *
	 * @return single instance of CallsColletion
	 */
	public static synchronized CallsColletion getInstance() {
		if (callsColletion == null) {
			callsColletion = new CallsColletion();
		}
		return callsColletion;

	}
	
	
	/**
	 * Add a call
	 * 
	 * @param call the call
	 */
	public void addCall(Call call) {

		Long id = call.getPhone1();
		List<Call> listCalls = getCalls(id);
		if (listCalls != null) {
			listCalls.add(call);
		} else {
			listCalls = new ArrayList<Call>();
			listCalls.add(call);
			calls.put(id, listCalls);
		}

		id = call.getPhone2();
		listCalls = getCalls(id);
		if (listCalls != null) {
			listCalls.add(call);
		} else {
			listCalls = new ArrayList<Call>();
			listCalls.add(call);
			calls.put(id, listCalls);
		}

	}

	/**
	 * Gets the calls.
	 *
	 * @param id the id
	 * @return the calls
	 */
	public List<Call> getCalls(Long id) {
		return calls.get(id);
	}
	
	/**
	 * Gets the calls and erase from the structure.
	 *
	 * @param id the id
	 * @return the calls and erase
	 */
	public List<Call> getCallsAndErase(Long id) {
		List<Call> listCalls =  calls.get(id);
		if(listCalls==null){
			listCalls =new ArrayList<Call>();
		}
		calls.remove(id);
		return listCalls;
	}
	
	/**
	 * Gets the calls and erase from the structure.
	 *
	 * @param listCallsInput the list calls input
	 * @return the calls and erase
	 */
	public List<Call> getCallsAndErase(List<Call> listCallsInput) {
		List<Call> listCallsOutuput = new ArrayList<Call>();
		
		for (Call call : listCallsInput) {
			listCallsOutuput.addAll(getCallsAndErase(call.getPhone1()));
			listCallsOutuput.addAll(getCallsAndErase(call.getPhone2()));
		}
		
		return listCallsOutuput;
	}
	
	

	/**
	 * Checks for data.
	 *
	 * @return true, if successful
	 */
	public boolean hasData(){
		return this.calls.size()>0;
	}
}
