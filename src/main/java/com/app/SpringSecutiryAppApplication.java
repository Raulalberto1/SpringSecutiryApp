package com.app;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.persistence.entity.PermissionEntity;
import com.app.persistence.entity.RoleEntity;
import com.app.persistence.entity.RoleEnum;
import com.app.persistence.entity.UserEntity;
import com.app.persistence.repository.UserRepository;

@SpringBootApplication
public class SpringSecutiryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecutiryAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();
			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();
			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();
			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();
			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();
			
			/*Create ROLES*/
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionEntities(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();
			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionEntities(Set.of(createPermission, readPermission))
					.build();
			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionEntities(Set.of(readPermission))
					.build();
			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionEntities(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();
			
			/* Create users*/
			UserEntity userRaul = UserEntity.builder()
					.username("raul")
					.password("1234")
					.isEnabled(true)
					.accountNotExpired(true)
					.accountNotLocked(true)
					.credentialNotExpired(true)
					.roles(Set.of(roleAdmin))
					.build();
			UserEntity userAlberto = UserEntity.builder()
					.username("alberto")
					.password("12345")
					.isEnabled(true)
					.accountNotExpired(true)
					.accountNotLocked(true)
					.credentialNotExpired(true)
					.roles(Set.of(roleUser))
					.build();
			
			userRepository.saveAll(List.of(userRaul, userAlberto));
		};
	}

}
