package br.com.wellingtoncosta.amd;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.wellingtoncosta.amd.repository.ColorRepositoryTesst;
import br.com.wellingtoncosta.amd.repository.UserRepositoryTest;
import br.com.wellingtoncosta.amd.viewmodel.ListColorsViewModelTest;
import br.com.wellingtoncosta.amd.viewmodel.ListUsersViewModelTest;

/**
 * @author Wellington Costa on 30/12/2017.
 */
@RunWith(Suite.class)
@SuiteClasses({
        UserRepositoryTest.class,
        ColorRepositoryTesst.class,
        ListUsersViewModelTest.class,
        ListColorsViewModelTest.class
})
public class TestSuite { }