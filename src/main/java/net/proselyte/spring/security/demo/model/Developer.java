/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package net.proselyte.spring.security.demo.model;

import lombok.Data;

@Data
//@AllArgsConstructor
public class Developer {
	private Long id;
	private String firstName;
	private String lastName;

	public Developer(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Устанавливает
	 *
	 * @param AbstractElement{name='id', isArray=false, isPrimitiveArray=false, isObjectArray=false, isStringArray=false, isCollection=false, isMap=false, isSet=false, isList=false, isPrimitive=false, isString=false, isNumeric=true, isObject=true, isDate=false, isCalendar=false, isBoolean=false, isLong=false, isFloat=false, isDouble=false, isVoid=false, isChar=false, isByte=false, isShort=false, typeName='Long', type='java.lang.Long', typeQualifiedName='java.lang.Long', isModifierStatic=false, isModifierPublic=false, isModifierProtected=false, isModifierPackageLocal=false, isModifierPrivate=true, isModifierFinal=false} ::: FieldElement{isConstant=false, isEnum=false, isModifierTransient=false, isModifierVolatile=false}
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Устанавливает
	 *
	 * @param AbstractElement{name='firstName', isArray=false, isPrimitiveArray=false, isObjectArray=false, isStringArray=false, isCollection=false, isMap=false, isSet=false, isList=false, isPrimitive=false, isString=true, isNumeric=false, isObject=true, isDate=false, isCalendar=false, isBoolean=false, isLong=false, isFloat=false, isDouble=false, isVoid=false, isChar=false, isByte=false, isShort=false, typeName='String', type='java.lang.String', typeQualifiedName='java.lang.String', isModifierStatic=false, isModifierPublic=false, isModifierProtected=false, isModifierPackageLocal=false, isModifierPrivate=true, isModifierFinal=false} ::: FieldElement{isConstant=false, isEnum=false, isModifierTransient=false, isModifierVolatile=false}
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Устанавливает
	 *
	 * @param AbstractElement{name='lastName', isArray=false, isPrimitiveArray=false, isObjectArray=false, isStringArray=false, isCollection=false, isMap=false, isSet=false, isList=false, isPrimitive=false, isString=true, isNumeric=false, isObject=true, isDate=false, isCalendar=false, isBoolean=false, isLong=false, isFloat=false, isDouble=false, isVoid=false, isChar=false, isByte=false, isShort=false, typeName='String', type='java.lang.String', typeQualifiedName='java.lang.String', isModifierStatic=false, isModifierPublic=false, isModifierProtected=false, isModifierPackageLocal=false, isModifierPrivate=true, isModifierFinal=false} ::: FieldElement{isConstant=false, isEnum=false, isModifierTransient=false, isModifierVolatile=false}
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}