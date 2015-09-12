package com.alibaba.druid.sql.dialect.mysql.ast.clause;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlBlockStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlStatementImpl;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitor;

/**
 * MySql create procedure statement
 * @author zz
 *
 */
public class MySqlCreateProcedureStatement extends MySqlStatementImpl {
	private boolean               orReplace;
    private SQLName               name;
    private MySqlBlockStatement  block;
    private List<MySqlParameter> parameters = new ArrayList<MySqlParameter>();

    @Override
    public void accept0(MySqlASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, name);
            acceptChild(visitor, parameters);
            acceptChild(visitor, block);
        }
        visitor.endVisit(this);
    }

    public List<MySqlParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<MySqlParameter> parameters) {
        this.parameters = parameters;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }

    public MySqlBlockStatement getBlock() {
        return block;
    }

    public void setBlock(MySqlBlockStatement block) {
        this.block = block;
    }

    public boolean isOrReplace() {
        return orReplace;
    }

    public void setOrReplace(boolean orReplace) {
        this.orReplace = orReplace;
    }

}