package github.scraper.business;

import github.scraper.rest.dto.ProjectDto;
import github.scraper.rest.dto.ProjectsDto;
import io.micronaut.retry.annotation.Fallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Fallback
public class FallbackGitHubService implements GitHubService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackGitHubService.class);

    @Override
    public ProjectsDto fetchProjectsAndStars() {
        LOGGER.warn("Failed to reach GitHub, someone call them!");
        return new ProjectsDto(List.of(
                new ProjectDto("fallback", 1)
        ));
    }
}
