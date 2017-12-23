package br.com.wellingtoncosta.amd.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Wellington Costa on 22/12/2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScoped {
}
