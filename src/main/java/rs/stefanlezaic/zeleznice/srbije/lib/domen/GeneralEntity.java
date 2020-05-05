package rs.stefanlezaic.zeleznice.srbije.lib.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface GeneralEntity extends Serializable {

    String getClassName();

    String getAtrValue();

    String setAtrValue();

    String getNameByColumn(int i);

    String getWhereCondition();

    String getExtraCondition(Object o);

    String getWhereNoPrimaryKey();

    String getSort();

    GeneralEntity getNewRecord(ResultSet rs) throws SQLException;

}
