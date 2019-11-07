package guru.springframework.converters;

import guru.springframework.commands.MealCategoryCommand;
import guru.springframework.domain.MealCategory;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MealCategoryToMealCategoryCommand implements Converter<MealCategory, MealCategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public MealCategoryCommand convert(MealCategory source) {
        if (source == null) {
            return null;
        }
        final MealCategoryCommand categoryCommand = new MealCategoryCommand();
        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());
        return categoryCommand;
    }
}