#!/usr/bin/env thrift --gen py --gen java

namespace java com.ficture.sneaky.thrift
namespace py sneaky

const string VERSION = "0.1.0"

struct User {
    1: required i64 user_id	
}

struct Account {
    1: required string service_kind,                # eg "facebook" or "twitter"
    2: required string handle,                      # eg "123949234" or "ssutch",
    3: required map<string, binary> attrs,          # eg "num_friends"=50,
    4: optional User associated_user,               # eg User(234)
    5: optional User owner,                         # eg User(526),
    6: optional map<string, binary> credentials     # eg oauth_secret=asdfsdfj
}

struct AccountsRequest {
    1: optional User user,
    2: optional string cursor,
    3: optional i32 direction
}

struct AccountsResult {
    1: required list<Account> accounts,
    2: optional string cursor
}

service Sneaky {
    void ping(),

    # create or update a user
    User putUser(1: User user),

    # remove a user and owned accounts (not associated accounts)
    void deleteUser(1: User user),

    # create or update an account
    Account putAccount(1: Account account),

    # remove an Account from the system
    void deleteAccount(1: Account account),

    # accounts for which this user is "owner"
    list<Account> getAssociatedAccounts(1: User user),

    # update this account's metadata and associated accounts
    void scrape(1: Account account),
}
