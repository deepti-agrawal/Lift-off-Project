package guru.springframework.converters;


import guru.springframework.commands.MealCategoryCommand;
import guru.springframework.domain.MealCategory;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MealCategoryCommandToMealCategory implements Converter<MealCategoryCommand, MealCategory>{

    @Synchronized
    @Nullable
    @Override
    public MealCategory convert(MealCategoryCommand source) {
        if (source == null) {
            return null;
        }

        final MealCategory category = new MealCategory();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}