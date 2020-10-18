package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.person.Module;
import seedu.address.model.person.UniqueModuleList;
import seedu.address.model.person.UniqueTutorialGroupList;

public class ModuleList implements ReadOnlyModuleList {

    private final UniqueModuleList modules = new UniqueModuleList();
    private UniqueTutorialGroupList tutorialGroups = new UniqueTutorialGroupList();


    public ModuleList() {}

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public ModuleList(ReadOnlyModuleList toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setModules(List<Module> modules) {
        this.modules.setModules(modules);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyModuleList newData) {
        requireNonNull(newData);

        setModules(newData.getModuleList());
    }

    //// module-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasModule(Module module) {
        requireNonNull(module);
        return modules.contains(module);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addModule(Module m) {
        modules.add(m);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setModule(Module target, Module editedModule) {
        requireNonNull(editedModule);

        modules.setModule(target, editedModule);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeModule(Module key) {
        modules.remove(key);
    }

    public void addTutorialGroup(TutorialGroup tutorialGroup) {
        tutorialGroups.add(tutorialGroup);
    }

    public boolean hasTutorialGroup(TutorialGroup tutorialGroup) {
        requireNonNull(tutorialGroup);
        return tutorialGroups.contains(tutorialGroup);
    }


    @Override
    public ObservableList<Module> getModuleList() {
        return modules.asUnmodifiableObservableList();
    }

    public ObservableList<TutorialGroup> getTutorialGroupList() {
        tutorialGroups.add(new TutorialGroup("trial"));
        return tutorialGroups.asUnmodifiableObservableList(); }

}
