package com.processor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryProcessor 
{
	private DataReader dataReader=new DataReader();
	private QueryParser queryParser=new QueryParser();
	Map<Integer,ArrayList<String>> dataSet=new LinkedHashMap<Integer,ArrayList<String>>();
	public Map<Integer,ArrayList<String>> executeQuery(String query)
	{
		queryParser=queryParser.extractParameters(query);
		/*if(query.contains("*"))
		{
		dataSet=dataReader.fetchAllData(queryParser);
		}
		else
		{
		dataSet=dataReader.fetchSelectiveColumnsData(queryParser.getRequiredColumnList(),dataReader.getAllHeaders(queryParser.geTableName()));
		}*/
		dataSet=dataReader.fetchDataWithwhereClause(queryParser.getRequiredColumnList(), dataReader.getAllHeaders(queryParser.geTableName()), queryParser.getCriteriaList(), queryParser.getLogicalOperatorList());
		return dataSet;
	}

}