package ${query.resolve("root.package.name")};

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "${query.resolve("type.name")}")
public class ${query.resolve("type.name")} implements Serializable {

<% query.resolve("type.fields").each{ 

	field ->
	if(!field.annotations.any({'JoinColumn'.equals(it.name.toString())})) {
		out << "@Column( name=\"${field.variables.get(0).id}\") ${field}";
	}	
 } 
 %>
 
 	public ${query.resolve("type.name")}(){}

}